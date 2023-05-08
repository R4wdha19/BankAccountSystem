package com.bankSystem.Bank.AccountSystem.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Setter
@Getter
@Entity

public class BankAccountTransaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    LocalDateTime dateTime;
    String description;
    Double amount;
    @JoinColumn(name = "creditCard_id", referencedColumnName = "id")
    @ManyToOne
    CreditCard creditCard;
}
