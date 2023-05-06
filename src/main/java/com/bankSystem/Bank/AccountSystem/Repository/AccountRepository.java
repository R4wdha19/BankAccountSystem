package com.bankSystem.Bank.AccountSystem.Repository;

import com.bankSystem.Bank.AccountSystem.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "select acc from Account acc")
    List<Account> getAllAccounts();

    @Query(value = "select acc from Account acc where acc.id = :accountId")
    Account getAccountById(@Param("accountId") Integer accountId);

    @Query(value = "select acc from Account acc where acc.accountNumber = :accountNumber")
    Account getAccountByAccountNumber(@Param("accountNumber") Integer accountNumber);

    @Query(value = "select acc from Account acc where acc.accountType = :accountType")
    List<Account> getByAccountType(@Param("accountType") String accountType);

    @Query(value = "select acc from Account acc where acc.accountBalance = :accountBalance")
    List<Account> getByAccountBalance(@Param("accountBalance") double accountBalance);

    @Query(value = "select acc.accountBalance from Account acc where acc.accountNumber = :accountNumber")
    public double getBalanceByAccountNumber(@Param("accountNumber")Integer accountNumber);

    @Query(value = "select acc.accountBalance from Account acc where acc.id = :accountId")
    public double getBalanceByAccountId(@Param("accountId")Integer accountId);

    @Query(value = "select acc from Account acc where acc.accountInterest = :accountInterest")
    List<Account> getByAccountInterest(@Param("accountInterest") double accountInterest);

    @Query(value = "select acc from Account acc where acc.isActive = 1")
    List<Account> getAllActiveAccounts();

    @Query(value = "select acc from Account acc where acc.isActive = 0")
    List<Account> getAllInActiveAccounts();

    @Query(value = "select * from account where updated_date like CONCAT (?1, '%') ", nativeQuery = true)
    List<Account> getByUpdatedDate(@Param("updatedDate")String updatedDate);

    @Query(value = "select * from account where created_date like CONCAT (?1, '%') ", nativeQuery = true)
    List<Account> getByCreatedDate(@Param("createdDate")String createdDate);


    @Query(value = "select acc from Account acc where acc.customer.id = :customerId")
    Account getAccountByCustomerId(@Param("customerId") Integer customerId);

    @Query(value = "select acc from Account acc where acc.id = (select Max(acc.id) from Account acc )")
    Account getLatestRow();


    @Query(value = "select acc from Account acc where acc.updatedDate = (select Max(acc.updatedDate) from  Account acc)")
    Account getLatestUpdated();

    @Query(value = "select acc from Account acc where acc.createdDate > :createdDate")
    List<Account> getAccountsCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Modifying
    @Transactional
    @Query(value = "update Account acc Set acc.isActive = false")
    void deleteAllAccounts();

    @Query(value = "select acc from Account acc where acc.createdDate >= :createdDate")
    List<Account> deleteAllAccountCreatedAfterDate(@Param("createdDate")Date createdDate);


}
