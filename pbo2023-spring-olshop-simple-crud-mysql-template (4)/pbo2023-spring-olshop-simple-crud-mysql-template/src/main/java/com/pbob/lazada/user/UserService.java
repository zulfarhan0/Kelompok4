package com.pbob.lazada.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbob.lazada.OrderItem.OrderItem;
import com.pbob.lazada.OrderItem.OrderItemRepository;

@Service
public class UserService {

      private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> ambilSemua() {
        return this.userRepository.findAll();
    }

    public void simpan(User user) {
        this.userRepository.save(user);
    }

    public void hapus(Long id) {
         this.userRepository.deleteById(id);
    }

    public User ambulById(Long id) {
         User user = this.userRepository.findById(id).orElse(null);

        return user;
    }

    public void ubah(Long id, User user) {
        User dataLama = this.userRepository.findById(id).orElse(null);

        dataLama.setUsername(user.getUsername());
        dataLama.setPassword(user.getPassword());
        dataLama.setRole(user.getRole());

        this.userRepository.save(dataLama);
    }
    
}
