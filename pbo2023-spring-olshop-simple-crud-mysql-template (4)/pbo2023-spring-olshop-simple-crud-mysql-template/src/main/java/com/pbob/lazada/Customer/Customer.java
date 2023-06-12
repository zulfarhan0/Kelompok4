package com.pbob.lazada.Customer;

import com.pbob.lazada.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String namaLengkap;
    private String NoHp;
    private String Alamat;

    @OneToOne
    private User User;

    
    public Customer() {
    }


    public Customer(int id, String namaLengkap, String NoHp, String Alamat) {
        this.id = id;
        this.namaLengkap = namaLengkap;
        this.NoHp = NoHp;
        this.Alamat = Alamat;
    }

}
