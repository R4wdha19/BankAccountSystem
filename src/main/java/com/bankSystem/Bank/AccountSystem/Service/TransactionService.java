package com.bankSystem.Bank.AccountSystem.Service;

import com.bankSystem.Bank.AccountSystem.Model.BankAccountTransaction;
import com.bankSystem.Bank.AccountSystem.Repository.BankAccountTransactionRepository;
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

    public void deleteAccountTransactionById() {

    }


    public void deleteAllAccountTransactionsCreatedAfterDate() {

    }

    public void deleteAccountTransactionByCreditCardId() {

    }

    public void deleteAccountTransactionByCreatedDate() {

    }

    public void deleteAccountTransactionByUpdatedDate() {

    }

    public void createAccountTransaction() {

    }

    public void updateAccountTransaction() {

    }


}
