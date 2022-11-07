package com.codegym.borrow_book.controller;

import com.codegym.borrow_book.exception.GiveBookBackException;
import com.codegym.borrow_book.exception.RentBookException;
import com.codegym.borrow_book.model.Book;
import com.codegym.borrow_book.service.IBookService;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
@Controller
@Aspect
@Component
public class BookController {

    private Map<Integer, Book> bookMap=new HashMap<>();

    @Autowired
    private IBookService bookService;

    @GetMapping("/books")
    public ModelAndView viewAllBook() {
        return new ModelAndView("list","books",bookService.getAllBooks());
    }

    @GetMapping("/toRentBook/{id}")
    public ModelAndView viewRentBook(@PathVariable(value = "id") int id) {
        Book book =bookService.getBookById(id);
        Random rand = new Random();
        int random = rand.nextInt(99999- 10000) + 10000;
        if(book==null) {
            return new ModelAndView("error");
        }
        ModelAndView modelAndView= new ModelAndView("rentBook","book",book);
        modelAndView.addObject("random",random);
        return modelAndView;
    }

    @PostMapping("/rentBook/{random}")
    public ModelAndView rentBook(@ModelAttribute Book book, @PathVariable(value = "random") int random) throws RentBookException {
        if(bookService.rentBook(book)) {
            bookMap.put(random, book);
            System.out.println(random);
            return new ModelAndView("list","books",bookService. getAllBooks());
        }
        throw new RentBookException() ;
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.borrow_book.controller.BookController.rentBook())")

    public void writeLog() {
        System.out.println("Hello");
    }

    @ExceptionHandler(RentBookException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("error");
    }

    
    @GetMapping("/give_book_back")
    public ModelAndView viewGiveBookBack() {
        return new ModelAndView("GiveBookBack","random", new Integer("0"));
    }

    @PostMapping("/give_book_back")
    public ModelAndView giveBookBack(@RequestParam int random) throws GiveBookBackException {
        System.out.println(random);
        if(bookMap.containsKey(random)) {
            Book book= bookMap.get(random);
            bookService.giveBookBack(book);
            bookMap.remove(random);
            return new ModelAndView("list","books",bookService.getAllBooks());
        }
        throw new GiveBookBackException();
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        Optional<Book> book = Optional.ofNullable(bookService.getBookById(id));
        ModelAndView modelAndView = new ModelAndView("/edit");
        return modelAndView;
    }


    @ExceptionHandler(GiveBookBackException.class)
    public ModelAndView showErrorGiveBookBack() {
        return new ModelAndView("errorGiveBookBack");
    }
}
