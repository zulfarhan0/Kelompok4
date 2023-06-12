package com.pbob.lazada.ProductCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
 
    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRepository){
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategory> ambilSemua() {
       return this.productCategoryRepository.findAll();
    }

    public void simpan(ProductCategory productCategory) {
        this.productCategoryRepository.save(productCategory);
    }

    public void hapus(Long id) {
        this.productCategoryRepository.deleteById(id);
    }

    public ProductCategory ambulById(Long id) {
        
        ProductCategory productCategory = this.productCategoryRepository.findById(id).orElse(null);

        return productCategory;
    }

    public void ubah(Long id, ProductCategory productCategory) {
        ProductCategory dataLama = this.productCategoryRepository.findById(id).orElse(null);

        dataLama.setKategori(productCategory.getKategori());

        this.productCategoryRepository.save(dataLama);
    }
}
