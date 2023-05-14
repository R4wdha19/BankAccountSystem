package com.bankSystem.Bank.AccountSystem.Utility;

public enum LoanStatusEnum {
    Current, //on-time payments
    Delinquent,  //missed payments
    Default, //failed to pay
    Foreclosure, //property used as collateral can be seized
    Repaid,  //loan paid off
    ChargedOff  //lender wrote off the loan as a loss
}
