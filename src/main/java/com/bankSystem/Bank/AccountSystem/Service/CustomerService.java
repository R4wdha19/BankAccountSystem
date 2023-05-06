package com.bankSystem.Bank.AccountSystem.Service;

import com.bankSystem.Bank.AccountSystem.Model.Customer;
import com.bankSystem.Bank.AccountSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerById(Integer customerId) {
        return customerRepository.getCustomerByCustomerId(customerId);
    }

    public List<Customer> getCustomerByCustomerFirstName(String customerFirstName) {
        return customerRepository.getCustomerByCustomerFirstName(customerFirstName);
    }

    public List<Customer> getCustomerByCustomerLastName(String customerLastName) {
        return customerRepository.getCustomerByCustomerLastName(customerLastName);
    }

    public Customer getCustomerByCustomerName(String firstName, String lastName) {
        return customerRepository.getCustomerByCustomerName(firstName, lastName);
    }

    public Customer getCustomerByCustomerPhoneNumber(String customerPhoneNumber) {
        return customerRepository.getCustomerByCustomerPhoneNumber(customerPhoneNumber);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public List<Customer> getAllActiveCustomers() {
        return customerRepository.getAllActiveCustomers();
    }

    public List<Customer> getAllInActiveCustomers() {
        return customerRepository.getAllInActiveCustomers();
    }

    public Customer getLatestRow() {
        return customerRepository.getLatestRow();
    }
    public Customer getLatestUpdated(){
        return customerRepository.getLatestUpdated();
    }
    public List<Customer> getCustomersCreatedAfterDate(Date createdDate){
        return customerRepository.getCustomersCreatedAfterDate(createdDate);
    }
    public List<Customer> getCustomersByUpdatedDate(String updatedDate){
        return customerRepository.getCustomersByUpdatedDate(updatedDate);
    }
    public List<Customer> getCustomersByCreatedDate(String createdDate){
        return customerRepository.getCustomersByCreatedDate(createdDate);
    }
}
