package com.bankSystem.Bank.AccountSystem.Controller;

import com.bankSystem.Bank.AccountSystem.Model.Account;
import com.bankSystem.Bank.AccountSystem.RequestObject.AccountRequest;
import com.bankSystem.Bank.AccountSystem.ResponseObject.AccountResponseObject;
import com.bankSystem.Bank.AccountSystem.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<AccountResponseObject> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts = accountService.getAllAccounts();
        List<AccountResponseObject> listOfConvertedAccounts = AccountResponseObject.covertToResponseList(accounts);
        return listOfConvertedAccounts;
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public AccountResponseObject getAccountById(@RequestParam Integer accountId) {
        Account accountToBeConverted = accountService.getAccountById(accountId);
        AccountResponseObject convertedAccount = AccountResponseObject.covertToResponse(accountToBeConverted);
        return convertedAccount;
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getByAccountNumber", method = RequestMethod.GET)
    public AccountResponseObject getAccountByAccountNumber(@RequestParam Integer accountNumber) {
        Account accountToBeConverted = accountService.getAccountByAccountNumber(accountNumber);
        AccountResponseObject accountResponseObject = AccountResponseObject.covertToResponse(accountToBeConverted);
        return accountResponseObject;
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getByAccountType", method = RequestMethod.GET)
    public List<AccountResponseObject> getByAccountType(String accountType) {
        List<Account> accountListByAccountType = new ArrayList<>();
        accountListByAccountType = accountService.getByAccountType(accountType);
        List<AccountResponseObject> listOfConvertedAccounts = AccountResponseObject.covertToResponseList(accountListByAccountType);
        return listOfConvertedAccounts;
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getByAccountBalance", method = RequestMethod.GET)
    public List<AccountResponseObject> getByAccountBalance(Double accountBalance) {
        List<Account> accountListByAccountBalance = new ArrayList<>();
        accountListByAccountBalance = accountService.getByAccountBalance(accountBalance);
        List<AccountResponseObject> listOfConvertedAccounts = AccountResponseObject.covertToResponseList(accountListByAccountBalance);
        return listOfConvertedAccounts;
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getBalanceByAccountNumber", method = RequestMethod.GET)
    //Retrieve the account balance for a specific account
    public AccountResponseObject getBalanceByAccountNumber(Integer accountNumber) {
        Double accountHavingACertainBalance = accountService.getBalanceByAccountNumber(accountNumber);
        AccountResponseObject accountResponseObject = AccountResponseObject.builder().number(accountNumber).balance(accountHavingACertainBalance).build();
        return accountResponseObject;
    }

    //    @RequestMapping(value = "getBalanceByAccountNumberMap", method = RequestMethod.GET)
//    //Retrieve the account balance for a specific account
//    public Map<String, Object> getBalanceByAccountNumberMap(Integer accountNumber) {
//        Double accountHavingACertainBalance = accountService.getBalanceByAccountNumber(accountNumber);
//        AccountResponseObject accountResponseObject = AccountResponseObject.builder().number(accountNumber).balance(accountHavingACertainBalance).build();
//        Map<String, Object> map = new HashMap<>();
//        map.put("number", accountNumber);
//        map.put("balance", accountHavingACertainBalance);
//        return map;
//    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getBalanceByAccountId", method = RequestMethod.GET)
    public AccountResponseObject getBalanceByAccountId(Integer accountId) {
        Double accountHavingACertainBalance = accountService.getBalanceByAccountId(accountId);
        AccountResponseObject accountResponseObject = AccountResponseObject.builder().id(accountId).balance(accountHavingACertainBalance).build();
        return accountResponseObject;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getByAccountInterest", method = RequestMethod.GET)
    public List<AccountResponseObject> getByAccountInterest(Double accountInterest) {
        List<Account> accountListByAccountInterest = new ArrayList<>();
        accountListByAccountInterest = accountService.getByAccountInterest(accountInterest);
        List<AccountResponseObject> convertedListOfAccounts = AccountResponseObject.covertToResponseList(accountListByAccountInterest);
        return convertedListOfAccounts;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getAllActiveAccounts", method = RequestMethod.GET)
    public List<AccountResponseObject> getAllActiveAccounts() {
        List<Account> activeAccounts = new ArrayList<>();
        activeAccounts = accountService.getAllActiveAccounts();
        List<AccountResponseObject> convertedListOfActiveAccounts = AccountResponseObject.covertToResponseList(activeAccounts);
        return convertedListOfActiveAccounts;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getAllInActiveAccounts", method = RequestMethod.GET)
    public List<AccountResponseObject> getAllInActiveAccounts() {
        List<Account> inActiveAccounts = new ArrayList<>();
        inActiveAccounts = accountService.getAllInActiveAccounts();
        List<AccountResponseObject> convertedListOfActiveAccounts = AccountResponseObject.covertToResponseList(inActiveAccounts);
        return convertedListOfActiveAccounts;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public List<AccountResponseObject> getByUpdatedDate(String updatedDate) {
        List<Account> listOfAccountsByUpdatedDate = new ArrayList<>();
        listOfAccountsByUpdatedDate = accountService.getByUpdatedDate(updatedDate);
        List<AccountResponseObject> convertedListOfAccounts = AccountResponseObject.covertToResponseList(listOfAccountsByUpdatedDate);
        return convertedListOfAccounts;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public List<AccountResponseObject> getByCreatedDate(String createdDate) {
        List<Account> listOfAccountsByCreatedDate = new ArrayList<>();
        listOfAccountsByCreatedDate = accountService.getByCreatedDate(createdDate);
        List<AccountResponseObject> convertedListOfAccounts = AccountResponseObject.covertToResponseList(listOfAccountsByCreatedDate);
        return convertedListOfAccounts;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getAccountByCustomerId", method = RequestMethod.GET)
    public AccountResponseObject getAccountByCustomerId(Integer customerId) {
        Account accountByCustomerId = accountService.getAccountByCustomerId(customerId);
        AccountResponseObject convertedAccountByCustomerId = AccountResponseObject.covertToResponse(accountByCustomerId);
        return convertedAccountByCustomerId;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public AccountResponseObject getLatestRow() {
        Account latestAccountRow = accountService.getAccountLatestRow();
        AccountResponseObject convertedLatestAccountRow = AccountResponseObject.covertToResponse(latestAccountRow);
        return convertedLatestAccountRow;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getLatestUpdatedAccount", method = RequestMethod.GET)
    public AccountResponseObject getLatestUpdatedAccount() {
        Account latestUpdatedAccount = accountService.getLatestUpdatedAccount();
        AccountResponseObject convertedLatestUpdatedAccount = AccountResponseObject.covertToResponse(latestUpdatedAccount);
        return convertedLatestUpdatedAccount;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "getAccountsCreatedAfterDate", method = RequestMethod.GET)
    public List<AccountResponseObject> getAccountsCreatedAfterDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date createdDate) {
        List<Account> listOfAccountsCreatedAfterDate = new ArrayList<>();
        listOfAccountsCreatedAfterDate = accountService.getAccountsCreatedAfterDate(createdDate);
        List<AccountResponseObject> convertedListOfAccounts = AccountResponseObject.covertToResponseList(listOfAccountsCreatedAfterDate);
        return convertedListOfAccounts;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllAccounts", method = RequestMethod.POST)
    public void deleteAllAccounts() {
        accountService.deleteAllAccounts();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllAccountCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllAccountCreatedAfterDate(Date createdDate) {
        accountService.deleteAllAccountCreatedAfterDate(createdDate);
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.POST)
    public void createAccount(@RequestBody AccountRequest accountRequest) {
        accountService.createAccount(accountRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "updateAccount", method = RequestMethod.POST)
    public void updateAccount(@RequestBody AccountRequest accountRequest) {
        accountService.updateAccount(accountRequest);
    }

    @RequestMapping(value = "getAccountBalanceInterest", method = RequestMethod.GET)
    public Double getAccountBalanceInterest(Integer accountId) {
        return accountService.getAccountBalanceInterest(accountId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public void deleteById(@RequestParam Integer accountId) {
        accountService.deleteById(accountId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteByAccountNumber", method = RequestMethod.POST)
    public void deleteByAccountNumber(@RequestParam Integer accountNumber) {
        accountService.deleteByAccountNumber(accountNumber);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteByAccountType", method = RequestMethod.POST)
    public void deleteByAccountType(@RequestParam String accountType) {
        accountService.deleteByAccountType(accountType);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteByAccountBalance", method = RequestMethod.POST)
    public void deleteByAccountBalance(@RequestParam Double accountBalance) {
        accountService.deleteByAccountBalance(accountBalance);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteByAccountInterest", method = RequestMethod.POST)
    public void deleteByAccountInterest(@RequestParam Double accountInterest) {
        accountService.deleteByAccountInterest(accountInterest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteByCustomerId", method = RequestMethod.POST)
    public void deleteByCustomerId(@RequestParam Integer customerId) {
        accountService.deleteByCustomerId(customerId);
    }


}
