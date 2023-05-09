package com.bankSystem.Bank.AccountSystem.Service;

import com.bankSystem.Bank.AccountSystem.Model.BankAccountTransaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    public BankAccountTransaction getAccountTransactionById();

    public List<BankAccountTransaction> getAllAccountTransactions();

    public List<BankAccountTransaction> getAllActiveAccountTransactions();

    public List<BankAccountTransaction> getAllInActiveAccountTransactions();

    public BankAccountTransaction getLatestRow();

    public BankAccountTransaction getLatestUpdated();

    public List<BankAccountTransaction> getAccountTransactionCreatedAfterDate();

    public List<BankAccountTransaction> getAllAccountTransactionByAmount();

    public List<BankAccountTransaction> getAccountTransactionsByUpdatedDate();

    public List<BankAccountTransaction> getAccountTransactionsByCreatedDate();

    public List<BankAccountTransaction> getAccountTransactionByCreditCardId();

    deleteAccountTransactionById


            deleteAllAccountTransactionsCreatedAfterDate

    deleteAccountTransactionByCreditCardId

            deleteAccountTransactionByCreatedDate

    deleteAccountTransactionByUpdatedDate

            createAccountTransaction

    updateAccountTransaction
    public void createTransaction(){

    }

}
