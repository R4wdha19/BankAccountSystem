package com.bankSystem.Bank.AccountSystem.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
public class Loan extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double principalAmount;
    Double interestRate;

    Integer termMonths;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne
    Customer customer;
}
