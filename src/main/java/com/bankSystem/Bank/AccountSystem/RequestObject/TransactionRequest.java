package com.bankSystem.Bank.AccountSystem.RequestObject;

import com.bankSystem.Bank.AccountSystem.Model.BankAccountTransaction;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@Builder
public class TransactionRequest {
    Integer transactionId;
    LocalDateTime dateTime;
    String description;
    Double amount;
    CreditCardRequest creditCardRequest;

    public static BankAccountTransaction convert(TransactionRequest request) {
        BankAccountTransaction bankAccountTransaction = new BankAccountTransaction();

    }
}
