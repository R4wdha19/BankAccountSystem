package com.bankSystem.Bank.AccountSystem.Repository;

import com.bankSystem.Bank.AccountSystem.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "select acc from Account acc")
    List<Account> getAllAccounts();
}
