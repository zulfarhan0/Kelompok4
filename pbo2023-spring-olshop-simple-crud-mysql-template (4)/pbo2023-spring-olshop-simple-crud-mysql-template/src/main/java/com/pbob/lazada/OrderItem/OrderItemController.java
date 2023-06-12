package com.pbob.lazada.OrderItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/orderitem")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService){
        this.orderItemService = orderItemService;
    }

    // Read Data
    @GetMapping("/")
    public String getAll(Model model) {
        List<OrderItem> dataOrderItems = this.orderItemService.ambilSemua();
        model.addAttribute("dataorderitem", dataOrderItems);
        return "orderitem/orderitem";
   }

      // tambah data/simpan
      @PostMapping("/simpan")
      public String simpan(@ModelAttribute OrderItem orderItem){
       this.orderItemService.simpan(orderItem);
            return "orderitem/orderitem";
      }

    //   Hapus data
      @GetMapping("/hapus{id}")
      public String hapus(@PathVariable Long id){
       this.orderItemService.hapus(id);
       return "redirect:/orderItem/";
      }

    // update data
    // memilih data yang akan di edit berdasarkan id
    @GetMapping("/edit{id}")
    public String edit(@PathVariable Long id, Model model){
    OrderItem orderItem = this.orderItemService.ambulById(id);

    model.addAttribute("orderItem", orderItem);

    return "orderItem/edit";
   }

   @GetMapping("/update{id}")
   public String update(@PathVariable Long id, @ModelAttribute OrderItem orderItem){
    this.orderItemService.ubah(id,orderItem);
    return "redirect:/orderItem/";
   }
}
