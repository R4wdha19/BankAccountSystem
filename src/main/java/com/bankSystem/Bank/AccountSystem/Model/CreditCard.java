package com.bankSystem.Bank.AccountSystem.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
public class CreditCard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer cardNumber;
    String cardHolderName;
    String cardType;

    String expiryDate;

    String securityCode;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @OneToOne
    Account account;

}
