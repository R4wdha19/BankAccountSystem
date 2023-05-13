package com.bankSystem.Bank.AccountSystem.Service;

import com.bankSystem.Bank.AccountSystem.Model.BankAccountTransaction;
import com.bankSystem.Bank.AccountSystem.Repository.BankAccountTransactionRepository;
import com.bankSystem.Bank.AccountSystem.RequestObject.TransactionRequest;
import com.bankSystem.Bank.AccountSystem.Utility.TransactionStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    BankAccountTransactionRepository bankAccountTransactionRepository;

    public BankAccountTransaction getAccountTransactionById(Integer bankAccountTransactionId) {
        return bankAccountTransactionRepository.getAccountTransactionById(bankAccountTransactionId);
    }

    public List<BankAccountTransaction> getAllAccountTransactions() {
        return bankAccountTransactionRepository.getAllAccountTransactions();
    }

    public List<BankAccountTransaction> getAllActiveAccountTransactions() {
        return bankAccountTransactionRepository.getAllActiveAccountTransactions();
    }

    public List<BankAccountTransaction> getAllInActiveAccountTransactions() {
        return bankAccountTransactionRepository.getAllInActiveAccountTransactions();
    }

    public BankAccountTransaction getLatestRow() {
        return bankAccountTransactionRepository.getLatestRow();
    }

    public BankAccountTransaction getLatestUpdated() {
        return bankAccountTransactionRepository.getLatestUpdatedRaw();
    }

    public List<BankAccountTransaction> getAccountTransactionCreatedAfterDate(Date createdDate) {
        List<BankAccountTransaction> bankAccountTransactionList = new ArrayList<>();
        bankAccountTransactionList = bankAccountTransactionRepository.getAccountTransactionCreatedAfterDate(createdDate);
        return bankAccountTransactionList;
    }

    public List<BankAccountTransaction> getAllAccountTransactionByAmount(Double bankAccountTransactionAmount) {
        List<BankAccountTransaction> bankAccountTransactionList = new ArrayList<>();
        bankAccountTransactionList = bankAccountTransactionRepository.getAllAccountTransactionByAmount(bankAccountTransactionAmount);
        return bankAccountTransactionList;
    }

    public List<BankAccountTransaction> getAccountTransactionsByUpdatedDate(String updatedDate) {
        List<BankAccountTransaction> bankAccountTransactionList = new ArrayList<>();
        bankAccountTransactionList = bankAccountTransactionRepository.getAccountTransactionsByUpdatedDate(updatedDate);
        return bankAccountTransactionList;
    }

    public List<BankAccountTransaction> getAccountTransactionsByCreatedDate(String createdDate) {
        List<BankAccountTransaction> bankAccountTransactionList = new ArrayList<>();
        bankAccountTransactionList = bankAccountTransactionRepository.getAccountTransactionsByCreatedDate(createdDate);
        return bankAccountTransactionList;
    }

    public List<BankAccountTransaction> getAccountTransactionByCreditCardId(Integer creditCardId) {
        List<BankAccountTransaction> bankAccountTransactionList = new ArrayList<>();
        bankAccountTransactionList = bankAccountTransactionRepository.getAccountTransactionByCreditCardId(creditCardId);
        return bankAccountTransactionList;
    }

    public void deleteAccountTransactionById(Integer id) {
        BankAccountTransaction bankAccountTransaction = bankAccountTransactionRepository.getAccountTransactionById(id);
        bankAccountTransaction.setIsActive(false);
        bankAccountTransactionRepository.save(bankAccountTransaction);
    }


    public void deleteAllAccountTransactionsCreatedAfterDate(Date createdDate) {
        List<BankAccountTransaction> accountTransactionList = new ArrayList<>();
        accountTransactionList = bankAccountTransactionRepository.getAccountTransactionCreatedAfterDate(createdDate);
        accountTransactionList.stream().forEach(at -> at.setIsActive(false));
        bankAccountTransactionRepository.saveAll(accountTransactionList);
    }

    public void deleteAccountTransactionByCreditCardId(Integer creditCardId) {
        List<BankAccountTransaction> bankAccountTransactionByCreditCardId = bankAccountTransactionRepository.getAccountTransactionByCreditCardId(creditCardId);
        bankAccountTransactionByCreditCardId.stream().forEach(x -> x.setIsActive(false));
        bankAccountTransactionRepository.saveAll(bankAccountTransactionByCreditCardId);
    }

    public void deleteAccountTransactionsByCreatedDate(String createdDate) {
        List<BankAccountTransaction> bankAccountTransactionByCreatedDate = bankAccountTransactionRepository.getAccountTransactionsByCreatedDate(createdDate);
        bankAccountTransactionByCreatedDate.stream().forEach(x -> x.setIsActive(false));
        bankAccountTransactionRepository.saveAll(bankAccountTransactionByCreatedDate);
    }

    public void deleteAccountTransactionsByUpdatedDate(String updatedDate) {
        List<BankAccountTransaction> bankAccountTransactionByUpdatedDate = bankAccountTransactionRepository.getAccountTransactionsByUpdatedDate(updatedDate);
        bankAccountTransactionByUpdatedDate.stream().forEach(x -> x.setIsActive(false));
        bankAccountTransactionRepository.saveAll(bankAccountTransactionByUpdatedDate);
    }

    public void createAccountTransaction(TransactionRequest transactionRequest) {
        BankAccountTransaction bankAccountTransaction = TransactionRequest.convert(transactionRequest);
        bankAccountTransactionRepository.save(bankAccountTransaction);
    }

    public void updateAccountTransaction(TransactionRequest transactionRequest, TransactionStatusEnum transactionStatusEnum) {
        BankAccountTransaction entity = bankAccountTransactionRepository.getAccountTransactionById(transactionRequest.getTransactionId());
        entity.setDescription(transactionRequest.getDescription());
        switch (transactionStatusEnum){
            case FAILED -> entity.setTransactionStatus(TransactionStatusEnum.FAILED);
            case SUCCESSFUL -> entity.setTransactionStatus(TransactionStatusEnum.SUCCESSFUL);
            case PENDING -> entity.setTransactionStatus(TransactionStatusEnum.PENDING);
            case RUNNING -> entity.setTransactionStatus(TransactionStatusEnum.RUNNING);
            case WAITING -> entity.setTransactionStatus(TransactionStatusEnum.WAITING);
        }

    }


}
