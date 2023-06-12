package com.pbob.lazada.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ProductController
 */
@Controller
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<Product> dataProduct = this.productService.getAll();
        model.addAttribute("dataProduct", dataProduct);
        return "product/index";
    }

    @GetMapping("/tambah")
    public String form_tambah(Model model) {
        return "product/tambah";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Product product) {
        this.productService.simpan(product);
        return "redirect:/product/";
    }

    @GetMapping("/edit/{id}")
    public String form_edit(@PathVariable Long id, Model model) {
        return "product/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Product product) {
        return "redirect:/product/";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        this.productService.hapus(id);
        return "redirect:/product/";
    }

        @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Product product = this.productService.detail(id);
        model.addAttribute("detailProduct", product);
        return "product/detail";
    }
}