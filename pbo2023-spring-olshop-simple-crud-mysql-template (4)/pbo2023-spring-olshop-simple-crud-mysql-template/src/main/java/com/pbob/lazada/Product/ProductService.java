package com.pbob.lazada.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ProductService
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public void simpan(Product product) {
        this.productRepository.save(product);
    }

    public void hapus(Long id) {
        this.productRepository.deleteById(id);
    }

    public Product detail(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

}