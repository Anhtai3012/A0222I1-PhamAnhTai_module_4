package codegym.service;

import codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
}
