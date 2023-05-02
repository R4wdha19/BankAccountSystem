package com.bankSystem.Bank.AccountSystem.Controller;

import com.bankSystem.Bank.AccountSystem.Model.Account;
import com.bankSystem.Bank.AccountSystem.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public Account getAccountById(@RequestParam Integer accountId){
        return accountService.getAccountById(accountId);
    }
    public 
}
