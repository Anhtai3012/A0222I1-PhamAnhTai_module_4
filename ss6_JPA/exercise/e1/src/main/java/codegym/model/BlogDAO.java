package codegym.model;

public class BlogDAO {
    Integer id;
    String title;
    Integer categoryId;

    public BlogDAO() {
    }

    public BlogDAO(Integer id, String title, Integer categoryId) {
        this.id = id;
        this.title = title;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
