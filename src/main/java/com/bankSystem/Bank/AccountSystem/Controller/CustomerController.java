package com.bankSystem.Bank.AccountSystem.Controller;

import com.bankSystem.Bank.AccountSystem.Model.Customer;
import com.bankSystem.Bank.AccountSystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "getAllCustomers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerService.getAllCustomers();
        return customerList;
    }

    @RequestMapping(value = "getCustomerById", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @RequestMapping(value = "getCustomerByCustomerFirstName", method = RequestMethod.GET)
    public List<Customer> getCustomerByCustomerFirstName(@RequestParam String firstName) {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerService.getCustomerByCustomerFirstName(firstName);
        return customerList;
    }

    @RequestMapping(value = "getCustomerByCustomerLastName", method = RequestMethod.GET)
    public List<Customer> getCustomerByCustomerLastName(@RequestParam String lastName) {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerService.getCustomerByCustomerLastName(lastName);
        return customerList;
    }
    @RequestMapping(value = "getCustomerByCustomerName", method = RequestMethod.GET)
    public Customer getCustomerByCustomerName(@RequestParam String firstName, @RequestParam String lastName) {
        return customerService.getCustomerByCustomerName(firstName, lastName);
    }
    @RequestMapping(value = "getCustomerByCustomerPhoneNumber", method = RequestMethod.GET)
    public Customer getCustomerByCustomerPhoneNumber(@RequestParam String phoneNumber){
        return customerService.getCustomerByCustomerPhoneNumber(phoneNumber);
    }
    @RequestMapping(value = "getAllActiveCustomers", method = RequestMethod.GET)
    public List<Customer> getAllActiveCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerService.getAllActiveCustomers();
        return customerList;
    }

    @RequestMapping(value = "getAllInActiveCustomers", method = RequestMethod.GET)
    public List<Customer> getAllInActiveCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerService.getAllInActiveCustomers();
        return customerList;
    }

            getLatestRow
    getLatestUpdated
            getCustomersCreatedAfterDate
    getCustomersByUpdatedDate
            getCustomersByCreatedDate
    deleteCustomerById
            deleteCustomerByCustomerFirstName
    deleteCustomerByCustomerLastName
            deleteCustomerByCustomerName
    deleteCustomerByCustomerPhoneNumber
            createCustomer
    updateCustomer
}
