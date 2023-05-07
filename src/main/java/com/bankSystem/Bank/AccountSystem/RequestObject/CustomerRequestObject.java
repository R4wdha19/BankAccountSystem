package com.bankSystem.Bank.AccountSystem.RequestObject;

import com.bankSystem.Bank.AccountSystem.Model.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter

public class CustomerRequestObject {

    Integer customerId;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;


    public static Customer convert(CustomerRequestObject customerRequestObject) {
        Customer customer = new Customer();
        customer.setFirstName(customerRequestObject.getFirstName());
        customer.setLastName(customerRequestObject.getLastName());
        customer.setEmail(customerRequestObject.getEmail());
        customer.setPhoneNumber(customerRequestObject.getPhoneNumber());
        customer.setIsActive(true);
        customer.setCreatedDate(new Date());
        return customer;
    }

    public static List<Customer> convert(List<CustomerRequestObject> customerRequestObjects) {
        List<Customer> customerList = new ArrayList<>();
        if (!customerRequestObjects.isEmpty()) {
            for (CustomerRequestObject customer : customerRequestObjects) {
                customerList.add(convert(customer));
            }
        }
        return customerList;
    }
}
