package com.bankSystem.Bank.AccountSystem.Repository;

import com.bankSystem.Bank.AccountSystem.Model.BankAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface BankAccountTransactionRepository extends JpaRepository<BankAccountTransaction, Integer> {
    @Query(value = "select bat from BankAccountTransaction bat where bat.transactionId = :bankAccountTransactionId")
    public BankAccountTransaction getAccountTransactionById(@Param("bankAccountTransactionId") Integer bankAccountTransactionId);

    @Query(value = "select bat from BankAccountTransaction bat")
    public List<BankAccountTransaction> getAllAccountTransactions();

    @Query(value = "select bat from BankAccountTransaction bat where bat.isActive = true")
    public List<BankAccountTransaction> getAllActiveAccountTransactions();

    @Query(value = "select bat from BankAccountTransaction bat where bat.isActive = false")
    public List<BankAccountTransaction> getAllInActiveAccountTransactions();

    @Query(value = "select bat from BankAccountTransaction bat where bat.transactionId = (select Max(bat.transactionId) from BankAccountTransaction bat )")
    public BankAccountTransaction getLatestRow();

    @Query(value = "select bat from BankAccountTransaction bat where bat.updatedDate = (select Max(bat.updatedDate) from BankAccountTransaction bat)")
    public BankAccountTransaction getLatestUpdatedRaw();

    @Query(value = "select bat from BankAccountTransaction bat where bat.createdDate > :createdDate")
    public List<BankAccountTransaction> getAccountTransactionCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value = "select bat from BankAccountTransaction bat where bat.transactionAmount = :amount")
    public List<BankAccountTransaction> getAllAccountTransactionByAmount(@Param("amount") Double bankAccountTransactionAmount);

    @Query(value = "select * from account where updated_date like CONCAT (?1, '%') ", nativeQuery = true)
    public List<BankAccountTransaction> getAccountTransactionsByUpdatedDate(@Param("updatedDate") String updatedDate);

    @Query(value = "select * from account where created_date like CONCAT (?1, '%') ", nativeQuery = true)
    public List<BankAccountTransaction> getAccountTransactionsByCreatedDate(@Param("createdDate") String createdDate);

    @Query(value = " select bat from BankAccountTransaction bat where bat.creditCard.id = :creditCardId")
    public List<BankAccountTransaction> getAccountTransactionByCreditCardId(@Param("creditCardId") Integer creditCardId);

    @Modifying
    @Transactional
    @Query(value = "update BankAccountTransaction bat Set bat.isActive = false")
    public void deleteAllAccountTransactions();

    @Query("select bat.transactionDescription from BankAccountTransaction bat where bat.accountNumber= :accountNumber")
    public BankAccountTransaction getAccountDescriptionByAccountNumber(@Param("accountNumber") Integer accountNumber);

}
