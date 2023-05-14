package com.bankSystem.Bank.AccountSystem.ResponseObject;

import com.bankSystem.Bank.AccountSystem.Model.BankAccountTransaction;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Data
public class TransactionResponseObject {
    Integer id;
    String status;
    LocalDateTime dateTime;
    String description;
    Double amount;

    public static TransactionResponseObject convertTransactionResponseObject(BankAccountTransaction requestOfBankAccountTransaction) {
        return TransactionResponseObject.builder()
                .id(requestOfBankAccountTransaction.getTransactionId())
                .status(requestOfBankAccountTransaction.getTransactionStatus().toString())
                .dateTime(requestOfBankAccountTransaction.getTransactionDateTime())
                .description(requestOfBankAccountTransaction.getTransactionDescription())
                .amount(requestOfBankAccountTransaction.getTransactionAmount())
                .build();

    }

    public static List<TransactionResponseObject> convertTransactionResponseList(List<BankAccountTransaction> requestOfBankAccountTransaction) {
        List<TransactionResponseObject> transactionResponseList = new ArrayList<>();
        if (!transactionResponseList.isEmpty()) {
            for (BankAccountTransaction responseList : requestOfBankAccountTransaction) {
                transactionResponseList.add(convertTransactionResponseObject(responseList));
            }
        }
        return transactionResponseList;
    }
}
