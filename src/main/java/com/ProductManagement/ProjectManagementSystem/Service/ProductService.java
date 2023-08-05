package com.ProductManagement.ProjectManagementSystem.Service;

import com.ProductManagement.ProjectManagementSystem.Model.Product;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> getAllProduct();

    public Product getProductId(Integer id);

    public String deleteProduct(Integer id);

    public Product editProduct(Product product,Integer id);

}
