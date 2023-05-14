package com.bankSystem.Bank.AccountSystem.ResponseObject;

import com.bankSystem.Bank.AccountSystem.Model.Account;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Data
public class AccountResponseObject {
    Integer id;
    Integer number;

    String type;

    Double balance;

    Double interest;

    public static AccountResponseObject covertToResponse(Account requestFromAccount) {
        return AccountResponseObject.builder()
                .number(requestFromAccount.getAccountNumber())
                .type(requestFromAccount.getAccountType())
                .balance(requestFromAccount.getAccountBalance())
                .interest(requestFromAccount.getAccountInterest())
                .build();
    }

    public static List<AccountResponseObject> covertToResponseList(List<Account> requestFromAccount) {
        List<AccountResponseObject> accountResponseList = new ArrayList<>();
        if (!requestFromAccount.isEmpty()) {
            for (Account account : requestFromAccount) {
                accountResponseList.add(covertToResponse(account));
            }
        }
        return accountResponseList;
    }
}
