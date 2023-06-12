package com.pbob.lazada.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Product
 */
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    private String deskripsi;
    private String brand;
    private int stok;
    private int harga;

    public Product() {
    }

    public Product(String nama, String deskripsi, String brand, int stok, int harga) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.brand = brand;
        this.stok = stok;
        this.harga = harga;
    }
}