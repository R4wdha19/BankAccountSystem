package com.bankSystem.Bank.AccountSystem.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Setter
@Getter
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer cardNumber;
    String cardHolderName;
    String cardType;

    String expiryDate;

    String securityCode;

    @OneToOne
    Account account;

}
