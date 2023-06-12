package com.pbob.lazada.Customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> ambilSemua() {
        return this.customerRepository.findAll();
    }

    public void simpan(Customer customer) {
        this.customerRepository.save(customer);
    }

    public void hapus(Long id) {
        this.customerRepository.deleteById(id);
    }

    public Customer ambulById(Long id) {

        Customer customer = this.customerRepository.findById(id).orElse(null);

        return customer;
    }

    public void ubah(Long id,Customer customer) {
        Customer dataLama = this.customerRepository.findById(id).orElse(null);

        dataLama.setNamaLengkap(customer.getNamaLengkap());
        dataLama.setNoHp(customer.getNoHp());
        dataLama.setAlamat(customer.getAlamat());

        this.customerRepository.save(dataLama);
    }
}
