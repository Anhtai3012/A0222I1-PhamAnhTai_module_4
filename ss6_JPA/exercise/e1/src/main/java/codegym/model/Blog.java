package codegym.model;

import codegym.service.CategoryService;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBlog;
    private String title;

    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category")
    private Category category;



    public Blog(String title1, Category category) {
        title = title1;
        this.category = category;
    }

//    public Blog(BlogDAO blogDAO) {
//        this.title = blogDAO.getTitle();
//        this.category = new Category(blogDAO.getCategoryId());
//    }

    public Blog() {
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title1) {
        this.title = title1;
    }

}
