package com.csi.service;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Formattable;
import java.util.List;
import java.util.Optional;
@Service

public class CustomerServiceImpl  implements  ICustomerService{

    @Autowired
    CustomerRepo customerRepo;
    @Override
    public Customer signUp(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public boolean signIn(String custEmailId, String custPassword) {
        boolean flag = false;
        for(Customer customer : customerRepo.findAll()) {
            if (customer!=null&&customer.getCustEmailId().equals(custEmailId)&&customer.getCustPassword().equals(custPassword));
            flag = true;
        }
        return false;
    }

    @Override
    public Optional<Customer> findById(int custId) {
        return customerRepo.findById(custId);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer changeAddress(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void deleteById(int custId) {

        customerRepo.deleteById(custId);
    }

    @Override
    public void deleteAll() {

        customerRepo.deleteAll();
    }
}
