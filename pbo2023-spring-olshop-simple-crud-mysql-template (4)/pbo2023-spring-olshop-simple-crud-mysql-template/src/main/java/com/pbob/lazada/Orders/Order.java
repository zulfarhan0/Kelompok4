package com.pbob.lazada.Orders;

import java.util.Date;
import java.util.List;

import com.pbob.lazada.Customer.Customer;
import com.pbob.lazada.OrderItem.OrderItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity


public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private Date tanggalOrder;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    private String status;
    private boolean paymentStatus;
    private String shippingStatus;

    public Order(){}

    public Order(Date tanggalOrder, String status, boolean paymentStatus, String shippingStatus) {
        this.tanggalOrder = tanggalOrder;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.shippingStatus = shippingStatus;
    }
}
