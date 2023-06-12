package com.pbob.lazada.Orders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbob.lazada.Product.Product;

@Service

public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> ambilSemua() {
        return this.orderRepository.findAll();
    }

    public void simpan(Order order) {
        this.orderRepository.save(order);
    }

    public void hapus(Long id) {
        this.orderRepository.deleteById(id);
    }

    public Order ambulById(Long id) {
        Order order = this.orderRepository.findById(id).orElse(null);

        return order;
    }

    public void ubah(Long id, Order order) {
        Order dataLama = this.orderRepository.findById(id).orElse(null);

        this.orderRepository.save(dataLama);
    }


    
}
