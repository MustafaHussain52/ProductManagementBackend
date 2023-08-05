package com.ProductManagement.ProjectManagementSystem.Controller;

import com.ProductManagement.ProjectManagementSystem.Model.Product;
import com.ProductManagement.ProjectManagementSystem.Service.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductId(@PathVariable Integer id){
        return new ResponseEntity<>(productService.getProductId(id), HttpStatus.OK);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
    return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
}

    @PostMapping("/editProduct/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product,@PathVariable Integer id) {
        return new ResponseEntity<>(productService.editProduct(product,id), HttpStatus.CREATED);
    }
}
