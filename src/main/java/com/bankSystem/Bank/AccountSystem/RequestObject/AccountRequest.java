package com.bankSystem.Bank.AccountSystem.RequestObject;

import com.bankSystem.Bank.AccountSystem.Model.Account;
import com.bankSystem.Bank.AccountSystem.Model.Customer;
import com.bankSystem.Bank.AccountSystem.Repository.CustomerRepository;
import com.bankSystem.Bank.AccountSystem.Service.AccountService;
import com.bankSystem.Bank.AccountSystem.Utility.HelperClass;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Setter
@Getter
@Builder
public class AccountRequest {

    Integer accountId;
    Integer accountNumber;
    Double accountBalance;
    String accountType;
    Double accountInterest;
    CustomerRequestObject customerRequestObject;


    public static Account convert(AccountRequest request) {
        Account account = new Account();
        account.setAccountInterest(request.getAccountInterest());
        account.setAccountNumber(request.getAccountNumber());
        account.setAccountBalance(request.getAccountBalance());
        account.setAccountType(request.getAccountType());
        account.setIsActive(true);
        account.setCreatedDate(new Date());
        account.setCustomer(CustomerRequestObject.convert(request.getCustomerRequestObject()));
        return account;
    }

    public static List<Account> convertList(List<AccountRequest> requestList) {
        List<Account> accountList = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (AccountRequest accountRequest : requestList) {
                accountList.add(convert(accountRequest));
            }
        }
        return accountList;

    }


}
