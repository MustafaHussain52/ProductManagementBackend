package com.ProductManagement.ProjectManagementSystem.Service;

import com.ProductManagement.ProjectManagementSystem.Model.Product;
import com.ProductManagement.ProjectManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductId(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public String deleteProduct(Integer id) {
   Product product = productRepository.findById(id).get();

   if (product != null){
       productRepository.delete(product);
       return "Product delete successfully";
   }
   return "Something went wrong";

    }
    @Override
    public Product editProduct(Product p, Integer id) {

        Product oldProduct = productRepository.findById(id).get();

        oldProduct.setProductName(p.getProductName());
        oldProduct.setDescription(p.getDescription());
        oldProduct.setPrice(p.getPrice());
        oldProduct.setStatus(p.getStatus());

        return productRepository.save(oldProduct);
    }
}
