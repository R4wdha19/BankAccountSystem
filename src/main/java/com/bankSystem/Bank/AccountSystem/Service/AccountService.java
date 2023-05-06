package com.bankSystem.Bank.AccountSystem.Service;

import com.bankSystem.Bank.AccountSystem.Model.Account;
import com.bankSystem.Bank.AccountSystem.Repository.AccountRepository;
import com.bankSystem.Bank.AccountSystem.Repository.CustomerRepository;
import com.bankSystem.Bank.AccountSystem.RequestObject.AccountRequest;
import com.bankSystem.Bank.AccountSystem.RequestObject.CustomerRequestObject;
import com.bankSystem.Bank.AccountSystem.Utility.HelperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerRequestObject customerRequestObject;

    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    public Account getAccountById(Integer id) {
        return accountRepository.getAccountById(id);
    }

    public Account getAccountByAccountNumber(Integer accountNumber) {
        return accountRepository.getAccountByAccountNumber(accountNumber);
    }


    public List<Account> getByAccountType(String accountType) {
        return accountRepository.getByAccountType(accountType);
    }

    public List<Account> getByAccountBalance(double accountBalance) {
        return accountRepository.getByAccountBalance(accountBalance);
    }

    public double getBalanceByAccountNumber(Integer accountNumber) {
        return accountRepository.getBalanceByAccountNumber(accountNumber);
    }

    public double getBalanceByAccountId(Integer accountId) {
        return accountRepository.getBalanceByAccountId(accountId);
    }

    public List<Account> getByAccountInterest(double accountInterest) {
        return accountRepository.getByAccountInterest(accountInterest);
    }

    public List<Account> getAllActiveAccounts() {
        return accountRepository.getAllActiveAccounts();
    }

    public List<Account> getAllInActiveAccounts() {
        return accountRepository.getAllInActiveAccounts();
    }

    public List<Account> getByUpdatedDate(String updatedDate) {
        return accountRepository.getByUpdatedDate(updatedDate);
    }

    public List<Account> getByCreatedDate(String createdDate) {
        return accountRepository.getByCreatedDate(createdDate);
    }

    public Account getAccountByCustomerId(Integer customerId) {
        return accountRepository.getAccountByCustomerId(customerId);
    }

    public Account getAccountLatestRow() {
        return accountRepository.getLatestRow();
    }

    public Account getLatestUpdatedAccount() {
        return accountRepository.getLatestUpdated();
    }

    public List<Account> getAccountsCreatedAfterDate(Date createdDate) {
        return accountRepository.getAccountsCreatedAfterDate(createdDate);
    }

    public void deleteAllAccounts() {
        accountRepository.deleteAllAccounts();
    }

    public void deleteAllAccountCreatedAfterDate(Date createdDate) {
        accountRepository.deleteAllAccountCreatedAfterDate(createdDate);
    }

    public void deleteById(Integer accountId) {
        Account account = getAccountById(accountId);
        account.setIsActive(false);
        accountRepository.save(account);
    }

    public void deleteByAccountNumber(Integer accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        account.setIsActive(false);
        accountRepository.save(account);
    }

    public void deleteByAccountType(String accountType) {
        List<Account> accountList = getByAccountType(accountType);
        accountList.stream().forEach(a -> a.setIsActive(false));
        accountRepository.saveAll(accountList);
    }

    public void deleteByAccountBalance(double accountBalance) {
        List<Account> accountList = getByAccountBalance(accountBalance);
        accountList.stream().forEach(a -> a.setIsActive(false));
        accountRepository.saveAll(accountList);
    }

    public void deleteByAccountInterest(double accountInterest) {
        List<Account> accountList = getByAccountInterest(accountInterest);
        accountList.stream().forEach(a -> a.setIsActive(false));
        accountRepository.saveAll(accountList);
    }

    public void deleteByCustomerId(Integer customerId) {
        Account account = getAccountByCustomerId(customerId);
        account.setIsActive(false);
        accountRepository.save(account);
    }

    public void createAccount(AccountRequest accountRequest) {
        Account account = AccountRequest.convert(accountRequest);
        accountRepository.save(account);
    }

    public Account updateAccount(AccountRequest request) {
        Account entity = accountRepository.getAccountByCustomerId(request.getCustomerRequestObject().getCustomerId());

        entity.setAccountInterest(HelperClass.compare(entity.getAccountInterest(), request.getAccountInterest()));
        entity.setAccountNumber(HelperClass.compare(entity.getAccountNumber(), request.getAccountNumber()));
        entity.setAccountBalance(HelperClass.compare(entity.getAccountBalance(), request.getAccountBalance()));
        entity.setAccountType(HelperClass.compare(entity.getAccountType(), request.getAccountType()));
        entity.setIsActive(true);
        entity.setCreatedDate(new Date());
        return entity;
    }
}
