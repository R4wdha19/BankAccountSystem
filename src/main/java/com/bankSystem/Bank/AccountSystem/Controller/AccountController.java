package com.bankSystem.Bank.AccountSystem.Controller;

import com.bankSystem.Bank.AccountSystem.Model.Account;
import com.bankSystem.Bank.AccountSystem.RequestObject.AccountRequest;
import com.bankSystem.Bank.AccountSystem.ResponseObject.AccountResponseObject;
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
    public List<AccountResponseObject> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts = accountService.getAllAccounts();
        List<AccountResponseObject> listOfConvertedAccounts = AccountResponseObject.covertToResponseList(accounts);
        return listOfConvertedAccounts;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public AccountResponseObject getAccountById(@RequestParam Integer accountId) {
        Account accountToBeConverted = accountService.getAccountById(accountId);
        AccountResponseObject convertedAccount = AccountResponseObject.covertToResponse(accountToBeConverted);
        return convertedAccount;
    }

    @RequestMapping(value = "getByAccountNumber", method = RequestMethod.GET)
    public AccountResponseObject getAccountByAccountNumber(@RequestParam Integer accountNumber) {
        Account accountToBeConverted = accountService.getAccountByAccountNumber(accountNumber);
        AccountResponseObject accountResponseObject = AccountResponseObject.covertToResponse(accountToBeConverted);
        return accountResponseObject;
    }

    @RequestMapping(value = "getByAccountType", method = RequestMethod.GET)
    public List<AccountResponseObject> getByAccountType(String accountType) {
        List<Account> accountListByAccountType = new ArrayList<>();
        accountListByAccountType = accountService.getByAccountType(accountType);
        List<AccountResponseObject> listOfConvertedAccounts = AccountResponseObject.covertToResponseList(accountListByAccountType);
        return listOfConvertedAccounts;
    }

    @RequestMapping(value = "getByAccountBalance", method = RequestMethod.GET)
    public List<AccountResponseObject> getByAccountBalance(Double accountBalance) {
        List<Account> accountListByAccountBalance = new ArrayList<>();
        accountListByAccountBalance = accountService.getByAccountBalance(accountBalance);
        List<AccountResponseObject> listOfConvertedAccounts = AccountResponseObject.covertToResponseList(accountListByAccountBalance);
        return listOfConvertedAccounts;
    }

    @RequestMapping(value = "getBalanceByAccountNumber", method = RequestMethod.GET)
    //Retrieve the account balance for a specific account
    public AccountResponseObject getBalanceByAccountNumber(Integer accountNumber) {
        Double accountHavingACertainBalance = accountService.getBalanceByAccountNumber(accountNumber);
        AccountResponseObject accountResponseObject = AccountResponseObject.builder().number(accountNumber).balance(accountHavingACertainBalance).build();
        return accountResponseObject;
    }

    @RequestMapping(value = "getByAccountId", method = RequestMethod.GET)
    public AccountResponseObject getBalanceByAccountId(Integer accountId) {
        Double accountHavingACertainBalance = accountService.getBalanceByAccountId(accountId);
        AccountResponseObject accountResponseObject = AccountResponseObject.builder().id(accountId).balance(accountHavingACertainBalance).build();
        return accountResponseObject;
    }

    @RequestMapping(value = "getByAccountInterest", method = RequestMethod.GET)
    public List<AccountResponseObject> getByAccountInterest(Double accountInterest) {
        List<Account> accountListByAccountInterest = new ArrayList<>();
        accountListByAccountInterest = accountService.getByAccountInterest(accountInterest);
        List<AccountResponseObject> convertedListOfAccounts = AccountResponseObject.covertToResponseList(accountListByAccountInterest);
        return convertedListOfAccounts;
    }

    @RequestMapping(value = "getAllActiveAccounts", method = RequestMethod.GET)
    public List<AccountResponseObject> getAllActiveAccounts() {
        List<Account> activeAccounts = new ArrayList<>();
        activeAccounts = accountService.getAllActiveAccounts();
        List<AccountResponseObject> convertedListOfActiveAccounts = AccountResponseObject.covertToResponseList(activeAccounts);
        return convertedListOfActiveAccounts;
    }

    @RequestMapping(value = "getAllInActiveAccounts", method = RequestMethod.GET)
    public List<AccountResponseObject> getAllInActiveAccounts() {
        List<Account> inActiveAccounts = new ArrayList<>();
        inActiveAccounts = accountService.getAllInActiveAccounts();
        List<AccountResponseObject> convertedListOfActiveAccounts = AccountResponseObject.covertToResponseList(inActiveAccounts);
        return convertedListOfActiveAccounts;
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public List<AccountResponseObject> getByUpdatedDate(String updatedDate) {
        List<Account> listOfAccountsByUpdatedDate = new ArrayList<>();
        listOfAccountsByUpdatedDate = accountService.getByUpdatedDate(updatedDate);
        List<AccountResponseObject> convertedListOfAccounts = AccountResponseObject.covertToResponseList(listOfAccountsByUpdatedDate);
        return convertedListOfAccounts;
    }

    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public List<AccountResponseObject> getByCreatedDate(String createdDate) {
        List<Account> listOfAccountsByCreatedDate = new ArrayList<>();
        listOfAccountsByCreatedDate = accountService.getByCreatedDate(createdDate);
        List<AccountResponseObject> convertedListOfAccounts = AccountResponseObject.covertToResponseList(listOfAccountsByCreatedDate);
        return convertedListOfAccounts;
    }

    @RequestMapping(value = "getAccountByCustomerId", method = RequestMethod.GET)
    public AccountResponseObject getAccountByCustomerId(Integer customerId) {
        Account accountByCustomerId = accountService.getAccountByCustomerId(customerId);
        AccountResponseObject convertedAccountByCustomerId = AccountResponseObject.covertToResponse(accountByCustomerId);
        return convertedAccountByCustomerId;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public AccountResponseObject getLatestRow() {
        Account latestAccountRow = accountService.getAccountLatestRow();
        AccountResponseObject convertedLatestAccountRow = AccountResponseObject.covertToResponse(latestAccountRow);
        return convertedLatestAccountRow;
    }

    @RequestMapping(value = "getLatestUpdatedAccount", method = RequestMethod.GET)
    public AccountResponseObject getLatestUpdatedAccount() {
        Account latestUpdatedAccount = accountService.getLatestUpdatedAccount();
        AccountResponseObject convertedLatestUpdatedAccount = AccountResponseObject.covertToResponse(latestUpdatedAccount);
        return convertedLatestUpdatedAccount;
    }

    @RequestMapping(value = "getAccountsCreatedAfterDate", method = RequestMethod.GET)
    public List<AccountResponseObject> getAccountsCreatedAfterDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date createdDate) {
        List<Account> listOfAccountsCreatedAfterDate = new ArrayList<>();
        listOfAccountsCreatedAfterDate = accountService.getAccountsCreatedAfterDate(createdDate);
        List<AccountResponseObject> convertedListOfAccounts = AccountResponseObject.covertToResponseList(listOfAccountsCreatedAfterDate);
        return convertedListOfAccounts;
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
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public void deleteById(@RequestParam Integer accountId) {
        accountService.deleteById(accountId);
    }
    @RequestMapping(value = "deleteByAccountNumber", method = RequestMethod.POST)
    public void deleteByAccountNumber(@RequestParam Integer accountNumber) {
        accountService.deleteByAccountNumber(accountNumber);
    }
    @RequestMapping(value = "deleteByAccountType", method = RequestMethod.POST)
    public void deleteByAccountType(@RequestParam String accountType) {
        accountService.deleteByAccountType(accountType);
    }
    @RequestMapping(value = "deleteByAccountBalance", method = RequestMethod.POST)
    public void deleteByAccountBalance(@RequestParam Double accountBalance) {
        accountService.deleteByAccountBalance(accountBalance);
    }
    @RequestMapping(value = "deleteByAccountInterest", method = RequestMethod.POST)
    public void deleteByAccountInterest(@RequestParam Double accountInterest) {
        accountService.deleteByAccountInterest(accountInterest);
    }
    @RequestMapping(value = "deleteByCustomerId", method = RequestMethod.POST)
    public void deleteByCustomerId(@RequestParam Integer customerId) {
        accountService.deleteByCustomerId(customerId);
    }


}
