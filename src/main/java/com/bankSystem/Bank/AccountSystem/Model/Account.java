package com.bankSystem.Bank.AccountSystem.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer accountNumber;

    String accountType;

    Double accountBalance;

    Double accountInterest;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @OneToOne(cascade=CascadeType.ALL)
    Customer customer;

}
