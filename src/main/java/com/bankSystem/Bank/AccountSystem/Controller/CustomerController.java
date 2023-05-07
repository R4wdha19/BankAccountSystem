package com.bankSystem.Bank.AccountSystem.Controller;

import com.bankSystem.Bank.AccountSystem.Model.Customer;
import com.bankSystem.Bank.AccountSystem.RequestObject.CustomerRequestObject;
import com.bankSystem.Bank.AccountSystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
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
    public Customer getCustomerByCustomerPhoneNumber(@RequestParam String phoneNumber) {
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

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Customer getLatestRow() {
        return customerService.getLatestRow();
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public Customer getLatestUpdated() {
        return customerService.getLatestUpdated();
    }

    @RequestMapping(value = "getCustomersCreatedAfterDate", method = RequestMethod.GET)
    public List<Customer> getCustomersCreatedAfterDate(Date createdDate) {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerService.getCustomersCreatedAfterDate(createdDate);
        return customerList;
    }

    @RequestMapping(value = "getCustomersByUpdatedDate", method = RequestMethod.GET)
    public List<Customer> getCustomersByUpdatedDate(String updatedDate) {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerService.getCustomersByUpdatedDate(updatedDate);
        return customerList;
    }

    @RequestMapping(value = "getCustomersByCreatedDate", method = RequestMethod.GET)
    public List<Customer> getCustomersByCreatedDate(String createdDate) {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerService.getCustomersByCreatedDate(createdDate);
        return customerList;
    }

    @RequestMapping(value = "deleteCustomerById", method = RequestMethod.POST)
    public void deleteCustomerById(Integer customerId) {
        customerService.deleteCustomerById(customerId);
    }

    @RequestMapping(value = "deleteCustomerByCustomerFirstName", method = RequestMethod.POST)
    public void deleteCustomerByCustomerFirstName(String firstName) {
        customerService.deleteCustomerByCustomerFirstName(firstName);
    }

    @RequestMapping(value = "deleteCustomerByCustomerLastName", method = RequestMethod.POST)
    public void deleteCustomerByCustomerLastName(String lastName) {
        customerService.deleteCustomerByCustomerLastName(lastName);
    }

    @RequestMapping(value = "deleteCustomerByCustomerName", method = RequestMethod.POST)
    public void deleteCustomerByCustomerName(String firstName, String lastName) {
        customerService.deleteCustomerByCustomerName(firstName, lastName);
    }

    @RequestMapping(value = "deleteCustomerByCustomerPhoneNumber", method = RequestMethod.POST)
    public void deleteCustomerByCustomerPhoneNumber(String phoneNumber) {
        customerService.deleteCustomerByCustomerPhoneNumber(phoneNumber);
    }

    @RequestMapping(value = "createCustomer", method = RequestMethod.POST)
    public void createCustomer(CustomerRequestObject customerRequestObject) {
        customerService.createCustomer(customerRequestObject);
    }

    @RequestMapping(value = "updateCustomer", method = RequestMethod.POST)
    public void updateCustomer(CustomerRequestObject customerRequestObject) {
        customerService.updateCustomer(customerRequestObject);
    }
}
