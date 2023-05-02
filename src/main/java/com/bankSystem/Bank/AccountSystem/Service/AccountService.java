package com.bankSystem.Bank.AccountSystem.Service;

import com.bankSystem.Bank.AccountSystem.Model.Account;
import com.bankSystem.Bank.AccountSystem.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
  public List<Account> getAllAccounts(){
      return accountRepository.getAllAccounts();
  }

}
