package com.pbob.lazada.Orders;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pbob.lazada.Customer.Customer;
import com.pbob.lazada.OrderItem.OrderItem;

import com.pbob.lazada.OrderItem.OrderItemService;
import com.pbob.lazada.Product.Product;
import com.pbob.lazada.Product.ProductService;

import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;
    private final OrderItemService orderItemService;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService, OrderItemService orderItemService){
        this.orderService = orderService;
        this.productService = productService;
        this.orderItemService = orderItemService;
    }

        // Read Data
        @GetMapping("/")
        public String tampil(){
            return "order/indexorder";
        }

        @GetMapping("/read")
        public String getAll(Model model) {
            List<Order> order = this.orderService.ambilSemua();
            model.addAttribute("Order", order);
            return "order/indexorder";
       }

       @GetMapping("/tambah{id}")
       public String tambah(Model model, @PathVariable Long id){
        Product product = this.productService.detail(id);
        model.addAttribute("product", product);
        return "order/tambah";
       }


       // tambah data/simpan
    //   @PostMapping("/simpan")
    //   public String simpan(@ModelAttribute Order order,@ModelAttribute OrderItem orderItem){
    //     //simpan data order
    //    this.orderService.simpan(order);

    //        return "redirect:/orderitem/orderitem";
    //   }

      //   Hapus data
      @GetMapping("/hapus{id}")
      public String hapus(@PathVariable Long id){
       this.orderService.hapus(id);
       return "redirect:/order/";
      }

       // update data
    // memilih data yang akan di edit berdasarkan id
    @GetMapping("/edit{id}")
    public String edit(@PathVariable Long id, Model model){
    Order order = this.orderService.ambulById(id);

    model.addAttribute("order", order);

    return "order/edit";
   }

   // mengganti data lama ke data baru
   @GetMapping("/update{id}")
   public String update(@PathVariable Long id, @ModelAttribute Order order){
    this.orderService.ubah(id,order);
    return "redirect:/order/";
   }

}
