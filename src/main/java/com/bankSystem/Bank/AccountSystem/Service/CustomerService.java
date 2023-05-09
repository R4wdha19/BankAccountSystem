package com.bankSystem.Bank.AccountSystem.Service;

import com.bankSystem.Bank.AccountSystem.Model.Customer;
import com.bankSystem.Bank.AccountSystem.Repository.CustomerRepository;
import com.bankSystem.Bank.AccountSystem.RequestObject.CustomerRequestObject;
import com.bankSystem.Bank.AccountSystem.Utility.HelperClass;
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

    public Customer getLatestUpdated() {
        return customerRepository.getLatestUpdated();
    }

    public List<Customer> getCustomersCreatedAfterDate(Date createdDate) {
        return customerRepository.getCustomersCreatedAfterDate(createdDate);
    }

    public List<Customer> getCustomersByUpdatedDate(String updatedDate) {
        return customerRepository.getCustomersByUpdatedDate(updatedDate);
    }

    public List<Customer> getCustomersByCreatedDate(String createdDate) {
        return customerRepository.getCustomersByCreatedDate(createdDate);
    }

    public void deleteCustomerById(Integer customerId) {
        Customer customer = customerRepository.getCustomerByCustomerId(customerId);
        customer.setIsActive(false);
        customer.setUpdatedDate(new Date());
        customerRepository.save(customer);
    }

    public void deleteCustomerByCustomerFirstName(String firstName) {
        List<Customer> customerList = customerRepository.getCustomerByCustomerFirstName(firstName);
        customerList.stream().forEach(f -> f.setIsActive(false));
        customerList.stream().forEach(u -> u.setUpdatedDate(new Date()));
        customerRepository.saveAll(customerList);
    }

    public void deleteCustomerByCustomerLastName(String lastName) {
        List<Customer> customerList = customerRepository.getCustomerByCustomerLastName(lastName);
        customerList.stream().forEach(f -> f.setIsActive(false));
        customerList.stream().forEach(u -> u.setUpdatedDate(new Date()));
        customerRepository.saveAll(customerList);
    }

    public void deleteCustomerByCustomerName(String firstName, String lastName) {
        Customer customer = customerRepository.getCustomerByCustomerName(firstName, lastName);
        customer.setIsActive(false);
        customer.setUpdatedDate(new Date());
        customerRepository.save(customer);
    }

    public void deleteCustomerByCustomerPhoneNumber(String phoneNumber) {
        Customer customer = customerRepository.getCustomerByCustomerPhoneNumber(phoneNumber);
        customer.setIsActive(false);
        customer.setUpdatedDate(new Date());
        customerRepository.save(customer);
    }

    public void createCustomer(CustomerRequestObject customerRequestObject) {
        Customer customer = CustomerRequestObject.convert(customerRequestObject);
        customerRepository.save(customer);
    }

    public Customer updateCustomer(CustomerRequestObject customerRequestObject){
       Customer entity = customerRepository.getCustomerByCustomerId(customerRequestObject.getCustomerId());
       entity.setFirstName(HelperClass.compare(entity.getFirstName(),customerRequestObject.getFirstName()));
       entity.setLastName(HelperClass.compare(entity.getLastName(),customerRequestObject.getLastName()));
       entity.setEmail(HelperClass.compare(entity.getEmail(),customerRequestObject.getEmail()));
       entity.setPhoneNumber(HelperClass.compare(entity.getPhoneNumber(),customerRequestObject.getPhoneNumber()));
       entity.setUpdatedDate(new Date());
       entity.setIsActive(true);
       return entity;
    }
}
