package com.bankSystem.Bank.AccountSystem.RequestObject;

import com.bankSystem.Bank.AccountSystem.Model.CreditCard;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
public class CreditCardRequest {
    Integer CreditCardId;
    Integer cardNumber;
    String cardHolderName;
    String cardType;
    String expiryDate;
    String securityCode;
    AccountRequest accountRequest;

    public static CreditCard convert(CreditCardRequest request) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(request.getCardNumber());
        creditCard.setCardHolderName(request.getCardHolderName());
        creditCard.setCardType(request.getCardType());
        creditCard.setExpiryDate(request.getExpiryDate());
        creditCard.setSecurityCode(request.getSecurityCode());
        creditCard.setAccount(AccountRequest.convert(request.getAccountRequest()));
        return creditCard;
    }

    public static List<CreditCard> convert(List<CreditCardRequest> request) {
        List<CreditCard> creditCardList = new ArrayList<>();
        if (!creditCardList.isEmpty()) {
            for (CreditCardRequest creditCardListRequest : request) {
                creditCardList.add(convert(creditCardListRequest));
            }
        }
        return creditCardList;
    }
}
