package com.bankSystem.Bank.AccountSystem.Controller;

import com.bankSystem.Bank.AccountSystem.Model.BankAccountTransaction;
import com.bankSystem.Bank.AccountSystem.ResponseObject.TransactionResponseObject;
import com.bankSystem.Bank.AccountSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "getAccountTransactionById", method = RequestMethod.GET)
    public TransactionResponseObject getAccountTransactionById(@RequestParam Integer accountId) {
        BankAccountTransaction accountTransaction = transactionService.getAccountTransactionById(accountId);
        TransactionResponseObject convertedAccountTransaction = TransactionResponseObject.convertTransactionResponseObject(accountTransaction);
        return convertedAccountTransaction;
    }
}
