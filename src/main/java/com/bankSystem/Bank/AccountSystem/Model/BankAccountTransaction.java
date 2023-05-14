package com.bankSystem.Bank.AccountSystem.Model;

import com.bankSystem.Bank.AccountSystem.Utility.TransactionStatusEnum;
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
    @Column(name = "id")
    Integer transactionId;
    @Enumerated(EnumType.STRING)
    TransactionStatusEnum transactionStatus;
    LocalDateTime transactionDateTime;
    String transactionDescription;
    Double transactionAmount;
    @JoinColumn(name = "creditCard_id", referencedColumnName = "id")
    @ManyToOne
    CreditCard creditCard;
}
