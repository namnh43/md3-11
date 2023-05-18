package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImp implements ProductService{
    private List<Product> products;

    public ProductServiceImp() {
        products = new ArrayList<>();
    }


    public void initProducts() {
        products.add(new Product("COMPUTER","Laptop",1000,"Laptop dell","Dell Inc"));
        products.add(new Product("COMPUTER","Desktop",1500,"Computer dell","Dell Inc"));
        products.add(new Product("COMPUTER","MacBook",2500,"Computer Apple","Apple Inc"));
        products.add(new Product("PRINTER","HP Printer",2500,"HP Printer","HP Inc"));
        products.add(new Product("PHONE","IPhone",1500,"Iphone 14","Apple"));
        products.add(new Product("PHONE","Samsung",1500,"Samsung","Samsung"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product deleteProductByIndex(int index) {
//        System.out.println(products);
        Product deletedProduct = products.remove(index);
        return deletedProduct;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public Product findProductByIndex(int index) {
        return products.get(index);
    }

    @Override
    public String toString() {
        return "ProductServiceImp{" +
                "products=" + products +
                '}';
    }
}
