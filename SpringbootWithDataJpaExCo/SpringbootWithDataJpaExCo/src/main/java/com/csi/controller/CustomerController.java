package com.csi.controller;


import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@RequestBody Customer customer) {
      return  new ResponseEntity<>(customerService.signUp(customer), HttpStatus.CREATED);
    }

    @GetMapping("/signin/{email}/{passowrd}")
    public ResponseEntity<Boolean> signIn(@PathVariable String email, @PathVariable String passowrd) {
        return new ResponseEntity<>(customerService.signIn(email, passowrd),HttpStatus.OK);
    }

    @GetMapping("/findbyid/{custId}")
    public ResponseEntity<Optional<Customer>> findbyid(@PathVariable int  custId) {
        return new ResponseEntity<>(customerService.findById(custId),HttpStatus.OK);
    }

    @PatchMapping("/changeaddress/{custId}/{custAddress}")
    public ResponseEntity <Customer> changeAddress(@PathVariable int custId, @RequestBody Customer customer,@PathVariable String custAddress) {
        Customer customer1=customerService.findById(custId).orElseThrow(()->new RecordNotFoundException("Customer Id does not exsists"));

            customer.setCustAddress(custAddress);
            return  new ResponseEntity<>(customerService.changeAddress(customer1),HttpStatus.OK);


    }

}
