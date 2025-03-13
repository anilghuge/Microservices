package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductDAO;
import com.example.demo.entity.Product;
import com.example.demo.service.IProductMgmtService;

@Service
public class ProductMgmtServiceImpl implements IProductMgmtService {

    // Create a logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(ProductMgmtServiceImpl.class);

    @Autowired
    private IProductDAO productDAO;

    // Adding a product: Clear the cache so it is refetched after saving the new product
    @CacheEvict(value = "prods", allEntries = true)  // Clears cache to ensure fresh data
    @Override
    public Product addProduct(Product product) {
        logger.info("Attempting to save product: {}", product);
        Product savedProduct = productDAO.save(product);  // Save the product
        logger.info("Product saved successfully with ID: {}", savedProduct.getPid());
        return savedProduct;
    }

    // Fetching all products: @Cacheable to retrieve data from cache if present
    @Cacheable(value = "prods")
    @Override
    public List<Product> showAllProducts() {
        logger.info("Fetching all products.");
        List<Product> products = productDAO.findAll();  // Retrieve all products
        logger.info("Fetched {} products successfully.", products.size());
        return products;
    }

    // Deleting a product: @CacheEvict to remove the specific product from cache
    @CacheEvict(value = "prods", key = "#pid")
    @Override
    public String deleteProduct(int pid) {
        logger.info("Attempting to delete product with ID: {}", pid);
        Optional<Product> optional = productDAO.findById(pid);
        if (optional.isPresent()) {
            productDAO.delete(optional.get());  // Delete the product from the database
            logger.info("Product with ID: {} deleted successfully.", pid);
            return String.format("%d deleted successfully", pid);
        } else {
            logger.warn("Product with ID: {} not found for deletion.", pid);
            return String.format("%d not found", pid);
        }
    }

    // Fetching a single product by ID: @Cacheable to cache the result
    @Cacheable(value = "prods", key = "#pid")
    @Override
    public Product findProductById(int pid) {
        logger.info("Fetching product with ID: {}", pid);
        Optional<Product> optional = productDAO.findById(pid);
        if (optional.isPresent()) {
            Product product = optional.get();
            logger.info("Product found: {}", product);
            return product;
        } else {
            logger.warn("Product with ID: {} not found.", pid);
            return null;
        }
    }
}


