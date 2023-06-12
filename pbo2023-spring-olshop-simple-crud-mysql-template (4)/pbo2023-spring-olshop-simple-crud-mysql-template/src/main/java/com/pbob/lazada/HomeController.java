package com.pbob.lazada;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pbob.lazada.Product.Product;
import com.pbob.lazada.Product.ProductService;

/*
 * HomeController
 * 
 * @Controller menandakan bahwa class ini adalah controller
 */

@Controller
public class HomeController {

        private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }
    
    /*
     * @GetMapping("/") menandakan bahwa method home() akan dipanggil ketika user mengakses URL http://localhost:8080/
     */
    @GetMapping("/home")
    public String home(Model model) {
        List<Product> produk = this.productService.getAll();

        model.addAttribute("dataProduct", produk);
        // Mengembalikan nama view yang akan ditampilkan, yaitu home.html
        return "home";
    }
}
