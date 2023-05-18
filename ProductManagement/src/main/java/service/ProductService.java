package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    public void initProducts();
    public List<Product> getAll();
    Product deleteProductByIndex(int index);
    void addProduct(Product product);
    Product findProductByIndex(int index);
}
