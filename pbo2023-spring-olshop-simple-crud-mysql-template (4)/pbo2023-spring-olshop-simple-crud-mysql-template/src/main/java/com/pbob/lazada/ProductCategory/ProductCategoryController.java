package com.pbob.lazada.ProductCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(path = "/kategori")

public class ProductCategoryController {
    
    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService){
        this.productCategoryService = productCategoryService;
    }

    // tampilkan data
    @GetMapping("/")
    public String getAll(Model model) {
        List<ProductCategory> dataKategori = this.productCategoryService.ambilSemua();

        model.addAttribute("dataKategori", dataKategori);

        return "productkategori/index";
    }

    //tambah data
    @GetMapping("/simpan")
    public String simpan(@ModelAttribute ProductCategory productCategory){
     this.productCategoryService.simpan(productCategory);
         return "redirect:/productkategori/";
    }

    //hapus data
    @GetMapping("/hapus{id}")
    public String hapus(@PathVariable Long id){
     this.productCategoryService.hapus(id);
     return "redirect:/productkategori/";
    }

    // update data
   // memilih data yang akan di edit berdasarkan id
   @GetMapping("/edit{id}")
   public String edit(@PathVariable Long id, Model model){
    ProductCategory productCategory = this.productCategoryService.ambulById(id);

    model.addAttribute("productCategory", productCategory);

    return "productkategori/edit";
   }

      // menambahkan data baru
      @GetMapping("/update{id}")
      public String update(@PathVariable Long id, @ModelAttribute ProductCategory productCategory){
       this.productCategoryService.ubah(id,productCategory);
       return "redirect:/productkategori/";
      }

}
