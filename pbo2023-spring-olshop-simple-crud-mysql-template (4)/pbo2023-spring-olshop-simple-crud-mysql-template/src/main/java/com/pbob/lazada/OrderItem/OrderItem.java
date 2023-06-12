package com.pbob.lazada.OrderItem;

import com.pbob.lazada.Orders.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.persistence.GenerationType;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int OrderId;
    private int ProductId;
    private int Jumlah;
    private String productName;

    public OrderItem(){
    }

    public OrderItem(int id, int OrderId, int ProductId, int Jumlah, String productName) {
        this.id = id;
        this.OrderId = OrderId;
        this.ProductId = ProductId;
        this.Jumlah = Jumlah;
        this.productName = productName;
    }

}
