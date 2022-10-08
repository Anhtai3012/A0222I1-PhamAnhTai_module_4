package codegym.service.impl;

import codegym.model.Product;
import codegym.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private  static List<Product> products = new ArrayList<>()  ;
    static {
        products.add(new Product(1,"iphone 14",2500,"active","apple"));
        products.add(new Product(2,"iphone 13",2000,"active","apple"));
        products.add(new Product(3,"iphone 12",1500,"active","apple"));
    }


    @Override
    public List<Product> findAll() {
        return products ;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product: products) {
            if (product.getId()==id)
                return product;
        };
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (Product product1: products) {
            if (product1.getId() == id){
               product1.setName(product.getName());
               product1.setPrice(product.getPrice());
               product1.setDescription(product.getDescription());
               product1.setBrand(product.getBrand());
               return;
            }
        }
    }

    @Override
    public boolean remove(int id) {
        for (Product product:products) {
            if (product.getId()==id)
                return products.remove(product);
        }
        return false;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> result = new ArrayList<>();
        for (int i = 0; i <products.size()-1 ; i++) {
            if (products.get(i).getName().contains(name)){
                 result.add(products.get(i));
                return result;
            }
        }
        return null;
    }
}
