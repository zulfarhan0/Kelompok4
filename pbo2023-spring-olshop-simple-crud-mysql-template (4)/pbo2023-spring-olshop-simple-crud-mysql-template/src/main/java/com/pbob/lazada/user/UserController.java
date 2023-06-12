package com.pbob.lazada.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pbob.lazada.OrderItem.OrderItem;
import com.pbob.lazada.OrderItem.OrderItemService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
        private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    //read data
    @GetMapping("/")
    public String getAll(Model model) {
        List<User> dataUser = this.userService.ambilSemua();
        model.addAttribute("dataUser", dataUser);
        return "user/index";
   }

      // tambah data/simpan
      @GetMapping("/simpan")
      public String simpan(@ModelAttribute User user){
       this.userService.simpan(user);
           return "redirect:/user/";
      }

          //   Hapus data
      @GetMapping("/hapus{id}")
      public String hapus(@PathVariable Long id){
       this.userService.hapus(id);
       return "redirect:/user/";
      }

          // update data
    // memilih data yang akan di edit berdasarkan id
    @GetMapping("/edit{id}")
    public String edit(@PathVariable Long id, Model model){
    User dataUser = this.userService.ambulById(id);

    model.addAttribute("dataUser", dataUser);

    return "user/edit";
   }

      @GetMapping("/update{id}")
   public String update(@PathVariable Long id, @ModelAttribute User user){
    this.userService.ubah(id,user);
    return "redirect:/user/";
   }
}
