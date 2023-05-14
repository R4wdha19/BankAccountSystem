package com.bankSystem.Bank.AccountSystem.Utility;

import java.time.LocalDateTime;
import java.util.Date;

public class HelperClass {
    public static String compare(String entity, String request) {
        if (request == null) {
            return entity;
        } else if (request.equals(entity)) {
            return entity;
        } else {
            return request;
        }
    }

    public static Integer compare(Integer entity, Integer request) {
        if (request == null) {
            return entity;
        } else if (request.equals(entity)) {
            return entity;
        } else {
            return request;
        }
    }

    public static Long compare(Long entity, Long request) {
        if (request == null) {
            return entity;
        } else if (request.equals(entity)) {
            return entity;
        } else {
            return request;
        }
    }

    public static Double compare(Double entity, Double request) {
        if (request == null) {
            return entity;
        } else if (request.equals(entity)) {
            return entity;
        } else {
            return request;
        }
    }

    public static Boolean compare(Boolean entity, Boolean request) {
        if (request == null) {
            return entity;
        } else if (request.equals(entity)) {
            return entity;
        } else {
            return request;
        }
    }

    public static LocalDateTime compare(LocalDateTime entity, LocalDateTime request) {
        if (request == null) {
            return entity;
        } else if (request.equals(entity)) {
            return entity;
        } else {
            return request;
        }
    }

    public static Date compare(Date entity, Date request) {
        if (request == null) {
            return entity;
        } else if (request.equals(entity)) {
            return entity;
        } else {
            return request;
        }
    }

    public static TransactionStatusEnum getTransactionStatusEnumFromStatus(String status){
        TransactionStatusEnum transactionStatusEnum = TransactionStatusEnum.SUCCESSFUL;
        switch (status){
            case "FAILED" -> transactionStatusEnum = TransactionStatusEnum.FAILED;
            case "PENDING" -> transactionStatusEnum = TransactionStatusEnum.PENDING;
            case "RUNNING" -> transactionStatusEnum = TransactionStatusEnum.RUNNING;
            case "WAITING" -> transactionStatusEnum = TransactionStatusEnum.WAITING;
        }
        return transactionStatusEnum;
    }
}
