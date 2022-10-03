package codegym.service.impl;

import codegym.model.Product;
import codegym.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
  private  static List<Product> products  ;
    static {
        products.add(new Product(1,"iphone 14",2500,"active","apple"));
        products.add(new Product(2,"iphone 13",2000,"active","apple"));
        products.add(new Product(1,"iphone 12",500,"active","apple"));
    }
    @Override
    public List<Product> findAll() {
        return  products = new ArrayList<>();
    }
}
