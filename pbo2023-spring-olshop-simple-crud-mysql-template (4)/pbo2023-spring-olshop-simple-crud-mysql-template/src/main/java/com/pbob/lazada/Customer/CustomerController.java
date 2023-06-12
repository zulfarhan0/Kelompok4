package com.pbob.lazada.Customer;

import java.util.List;


import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    // Read Data
    @GetMapping("/")
    public String getAll(Model model) {
        List<Customer> dataCustomers = this.customerService.ambilSemua();
        model.addAttribute("dataCustomer", dataCustomers);
        return "customer/index";
   }

   // tambah data/simpan
   @GetMapping("/simpan")
   public String simpan(@ModelAttribute Customer customer){
    this.customerService.simpan(customer);
        return "redirect:/customer/";
   }

   // hapus data
   @GetMapping("/hapus{id}")
   public String hapus(@PathVariable Long id){
    this.customerService.hapus(id);
    return "redirect:/customer/";
   }

   // update data
   // memilih data yang akan di edit berdasarkan id
   @GetMapping("/edit{id}")
   public String edit(@PathVariable Long id, Model model){
    Customer customer = this.customerService.ambulById(id);

    model.addAttribute("customer", customer);

    return "customer/edit";
   }

   // menambahkan data baru
   @GetMapping("/update{id}")
   public String update(@PathVariable Long id, @ModelAttribute Customer customer){
    this.customerService.ubah(id,customer);
    return "redirect:/customer/";
   }

}
