package com.bankSystem.Bank.AccountSystem.Utility;

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
}
