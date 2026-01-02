package com.stack.cards.mapper;

import com.stack.cards.dto.CardsDTO;
import com.stack.cards.entity.Cards;

public class CardsMapper {
    public static CardsDTO mapToCardDTO(Cards cards, CardsDTO cardsDTO){
        cardsDTO.setCardNumber(cards.getCardNumber());
        cardsDTO.setCardType(cards.getCardType());
        cardsDTO.setAvailableAmount(cards.getAvailableAmount());
        cardsDTO.setAmountUsed(cards.getAmountUsed());
        cardsDTO.setMobileNumber(cards.getMobileNumber());
        cardsDTO.setTotalLimit(cards.getTotalLimit());
        return cardsDTO;
    }

    public static Cards mapToCard(CardsDTO cardsDTO, Cards cards){
        cards.setCardNumber(cardsDTO.getCardNumber());
        cards.setCardType(cardsDTO.getCardType());
        cards.setAvailableAmount(cardsDTO.getAvailableAmount());
        cards.setAmountUsed(cardsDTO.getAmountUsed());
        cards.setMobileNumber(cardsDTO.getMobileNumber());
        cards.setTotalLimit(cardsDTO.getTotalLimit());
        return cards;
    }
}
