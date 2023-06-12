package com.pbob.lazada.OrderItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository){
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> ambilSemua() {
        return this.orderItemRepository.findAll();
    }

    public void simpan(OrderItem orderItem) {
        this.orderItemRepository.save(orderItem);
    }

    public void hapus(Long id) {
        this.orderItemRepository.deleteById(id);
    }

    public OrderItem ambulById(Long id) {
        OrderItem orderItem = this.orderItemRepository.findById(id).orElse(null);

        return orderItem;
    }

    public void ubah(Long id, OrderItem orderItem) {
        OrderItem dataLama = this.orderItemRepository.findById(id).orElse(null);

        dataLama.setOrderId(orderItem.getOrderId());
        dataLama.setProductId(orderItem.getProductId());
        dataLama.setJumlah(orderItem.getJumlah());

        this.orderItemRepository.save(dataLama);
    }

}
