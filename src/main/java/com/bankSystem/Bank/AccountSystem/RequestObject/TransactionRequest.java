package com.bankSystem.Bank.AccountSystem.RequestObject;

import com.bankSystem.Bank.AccountSystem.Model.BankAccountTransaction;
import com.bankSystem.Bank.AccountSystem.Utility.HelperClass;
import com.bankSystem.Bank.AccountSystem.Utility.TransactionStatusEnum;
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
    String status;
    CreditCardRequest creditCardRequest;

    public static BankAccountTransaction convertTransactionObject(TransactionRequest request) {
        BankAccountTransaction bankAccountTransaction = new BankAccountTransaction();
        bankAccountTransaction.setTransactionDateTime(request.getDateTime());
        bankAccountTransaction.setTransactionDescription(request.getDescription());
        bankAccountTransaction.setTransactionAmount(request.getAmount());
        bankAccountTransaction.setIsActive(true);
        bankAccountTransaction.setCreatedDate(new Date());
        bankAccountTransaction.setCreditCard(CreditCardRequest.convert(request.getCreditCardRequest()));
        bankAccountTransaction.setTransactionStatus(HelperClass.getTransactionStatusEnumFromStatus(request.getStatus()));
        return bankAccountTransaction;
    }

    public static List<BankAccountTransaction> convertTransactionList(List<TransactionRequest> request) {
        List<BankAccountTransaction> bankAccountTransactionList = new ArrayList<>();
        if (!bankAccountTransactionList.isEmpty()) {
            for (TransactionRequest transactionRequest : request) {
                bankAccountTransactionList.add(TransactionRequest.convertTransactionObject(transactionRequest));
            }
        }
        return bankAccountTransactionList;
    }
}
