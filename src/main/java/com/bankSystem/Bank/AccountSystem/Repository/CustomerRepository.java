package com.bankSystem.Bank.AccountSystem.Repository;

import com.bankSystem.Bank.AccountSystem.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select c from Customer c where c.id = :customerId")
    public Customer getCustomerByCustomerId(@Param("customerId")Integer customerId);

    @Query(value = "select c from Customer c where c.firstName = :customerFirstName")
    public List<Customer> getCustomerByCustomerFirstName(@Param("customerFirstName")String customerFirstName);

    @Query(value = "select c from Customer c where c.lastName = :customerLastName")
    public List<Customer> getCustomerByCustomerLastName(@Param("customerLastName")String customerLastName);

    @Query("select c from Customer c where c.firstName =:firstName and c.lastName =:lastName")
    public Customer getCustomerByCustomerName(@Param("firstName")String firstName,@Param("lastName") String lastName);

    @Query(value = "select c from Customer c where c.phoneNumber = :customerPhoneNumber")
    public Customer getCustomerByCustomerPhoneNumber(@Param("customerPhoneNumber")String customerPhoneNumber);

    @Query(value = "select c from Customer c")
    public List<Customer> getAllCustomers();

    @Query(value = "select c from Customer c where c.isActive = 1")
    public List<Customer> getAllActiveCustomers();

    @Query(value = "select c from Customer c where c.isActive = 0")
    public List<Customer> getAllInActiveCustomers();

    @Query(value = "select c from Customer c where c.id = (select Max(c.id) from Customer c )")
    public Customer getLatestRow();

    @Query(value = "select c from Customer c where c.updatedDate = (select Max(c.updatedDate) from Customer c)")
    public Customer getLatestUpdated();

    @Query(value = "select c from Customer c where c.createdDate> :createdDate")
    public List<Customer> getCustomersCreatedAfterDate(@Param("createdDate")Date createdDate);

    @Query(value = "select * from customer  where updated_date like CONCAT (?1, '%') ", nativeQuery = true)
    public List<Customer> getCustomersByUpdatedDate(@Param("updatedDate")String updatedDate);

    @Query(value = "select * from customer  where created_date like CONCAT (?1, '%') ", nativeQuery = true)
    public List<Customer> getCustomersByCreatedDate(@Param("createdDate")String createdDate);

}
