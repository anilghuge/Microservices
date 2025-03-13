package com.example.demo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.IProductMgmtService;

@RestController
@RequestMapping("/product-api")
public class ProductOperationControllers {
	
    private static final Logger logger = LoggerFactory.getLogger(ProductOperationControllers.class);

    @Autowired
    private IProductMgmtService productMgmtService;

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        logger.info("Attempting to save product: {}", product);
        Product response = productMgmtService.addProduct(product);
        logger.info("Product saved successfully: {}", response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getAllProduct() {
        logger.info("Fetching all products.");
        List<Product> products = productMgmtService.showAllProducts();
        logger.info("Successfully fetched all products. Total: {}", products.size());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/get/{pid}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer pid) {
        logger.info("Fetching product with ID: {}", pid);
        Product product = productMgmtService.findProductById(pid);
        if (product != null) {
            logger.info("Product found: {}", product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            logger.warn("Product with ID: {} not found", pid);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<String> deleteById(@PathVariable Integer pid) {
        logger.info("Attempting to delete product with ID: {}", pid);
        String response = productMgmtService.deleteProduct(pid);
        logger.info("Product deletion response: {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
