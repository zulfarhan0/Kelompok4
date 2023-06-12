package com.pbob.lazada.ProductCategory;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String kategori;

    public ProductCategory() {
    }


    public ProductCategory(int id, String kategori) {
        this.id = id;
        this.kategori = kategori;
    }

}
