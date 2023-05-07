package com.bankSystem.Bank.AccountSystem.Controller;

import com.bankSystem.Bank.AccountSystem.Model.Account;
import com.bankSystem.Bank.AccountSystem.RequestObject.AccountRequest;
import com.bankSystem.Bank.AccountSystem.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    AccountService accountService;


    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts = accountService.getAllAccounts();
        return accounts;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Account getAccountById(@RequestParam Integer accountId) {
        return accountService.getAccountById(accountId);
    }

    @RequestMapping(value = "getByAccountNumber", method = RequestMethod.GET)
    //Retrieve the account balance for a specific account
    public Account getAccountByAccountNumber(@RequestParam Integer accountNumber) {
        return accountService.getAccountByAccountNumber(accountNumber);
    }

    @RequestMapping(value = "getByAccountType", method = RequestMethod.GET)
    public List<Account> getByAccountType(String accountType) {
        List<Account> accountListByAccountType = accountService.getByAccountType(accountType);
        return accountListByAccountType;
    }

    @RequestMapping(value = "getByAccountBalance", method = RequestMethod.GET)
    public List<Account> getByAccountBalance(Double accountBalance) {
        List<Account> accountListByAccountBalance = accountService.getByAccountBalance(accountBalance);
        return accountListByAccountBalance;
    }

    @RequestMapping(value = "getBalanceByAccountNumber", method = RequestMethod.GET)
    public Double getBalanceByAccountNumber(Integer accountNumber) {
        return accountService.getBalanceByAccountNumber(accountNumber);
    }

    @RequestMapping(value = "getByAccountId", method = RequestMethod.GET)
    public Double getBalanceByAccountId(Integer accountId) {
        return accountService.getBalanceByAccountId(accountId);
    }

    @RequestMapping(value = "getByAccountInterest", method = RequestMethod.GET)
    public List<Account> getByAccountInterest(Double accountInterest) {
        List<Account> accountListByAccountInterest = accountService.getByAccountInterest(accountInterest);
        return accountListByAccountInterest;
    }

    @RequestMapping(value = "getAllActiveAccounts", method = RequestMethod.GET)
    public List<Account> getAllActiveAccounts() {
        return accountService.getAllActiveAccounts();
    }

    @RequestMapping(value = "getAllInActiveAccounts", method = RequestMethod.GET)
    public List<Account> getAllInActiveAccounts() {
        return accountService.getAllInActiveAccounts();
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public List<Account> getByUpdatedDate(String updatedDate) {
        return accountService.getByUpdatedDate(updatedDate);
    }

    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public List<Account> getByCreatedDate(String createdDate) {
        return accountService.getByCreatedDate(createdDate);
    }

    @RequestMapping(value = "getAccountByCustomerId", method = RequestMethod.GET)
    public Account getAccountByCustomerId(Integer customerId) {
        return accountService.getAccountByCustomerId(customerId);
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Account getLatestRow() {
        return accountService.getAccountLatestRow();
    }

    @RequestMapping(value = "getLatestUpdatedAccount", method = RequestMethod.GET)
    public Account getLatestUpdatedAccount() {
        return accountService.getLatestUpdatedAccount();
    }

    @RequestMapping(value = "getAccountsCreatedAfterDate", method = RequestMethod.GET)
    public List<Account> getAccountsCreatedAfterDate(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date createdDate) {
        return accountService.getAccountsCreatedAfterDate(createdDate);
    }

    @RequestMapping(value = "deleteAllAccounts", method = RequestMethod.POST)
    public void deleteAllAccounts() {
        accountService.deleteAllAccounts();
    }

    @RequestMapping(value = "deleteAllAccountCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllAccountCreatedAfterDate(Date createdDate) {
        accountService.deleteAllAccountCreatedAfterDate(createdDate);
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.POST)
    public void createAccount(@RequestBody AccountRequest accountRequest) {
        accountService.createAccount(accountRequest);
    }

    @RequestMapping(value = "updateAccount", method = RequestMethod.POST)
    public void updateAccount(@RequestBody AccountRequest accountRequest) {
        accountService.updateAccount(accountRequest);
    }
    @RequestMapping(value = "getAccountBalanceInterest", method = RequestMethod.GET)
    public Double getAccountBalanceInterest(Integer accountId) {
        return accountService.getAccountBalanceInterest(accountId);
    }

}
