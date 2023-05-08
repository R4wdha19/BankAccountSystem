package com.bankSystem.Bank.AccountSystem.RequestObject;

import com.bankSystem.Bank.AccountSystem.Model.BankAccountTransaction;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Setter
@Getter
public class TransactionRequest {
    Integer transactionId;
    LocalDateTime dateTime;
    String description;
    Double amount;

    CreditCardRequest creditCardRequest;

    public static BankAccountTransaction convert(TransactionRequest request) {
        BankAccountTransaction bankAccountTransaction = new BankAccountTransaction();
        bankAccountTransaction.setDateTime(request.getDateTime());
        bankAccountTransaction.setDescription(request.getDescription());
        bankAccountTransaction.setAmount(request.getAmount());
        bankAccountTransaction.setIsActive(true);
        bankAccountTransaction.setCreatedDate(new Date());
        bankAccountTransaction.setCreditCard(CreditCardRequest.convert(request.getCreditCardRequest()));
        return bankAccountTransaction;
    }

    public static List<BankAccountTransaction> convert(List<TransactionRequest> request) {
        List<BankAccountTransaction> bankAccountTransactionList = new ArrayList<>();
        if (!bankAccountTransactionList.isEmpty()) {
            for (TransactionRequest transactionRequest : request) {
                bankAccountTransactionList.add(TransactionRequest.convert(transactionRequest));
            }
        }
        return bankAccountTransactionList;
    }
}
