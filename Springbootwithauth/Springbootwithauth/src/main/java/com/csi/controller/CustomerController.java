package com.csi.controller;

import com.csi.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    List<Customer> customers= Stream.of(new Customer(121,"Rushikesh", "Nighot"),new Customer(122,"Kiran","Chauhan"),new Customer(123,"SOMANATH","BHOSALE"),new Customer(124,"Sahil","kaoklhe"),new Customer(125,"Vaibhav","chill")).toList();


    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortByName(){
        return ResponseEntity.ok(customers.stream().sorted(Comparator.comparing(Customer::getCustName)).toList());
    }



}
