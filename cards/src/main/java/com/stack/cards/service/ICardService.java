package com.stack.cards.service;

import com.stack.cards.dto.CardsDTO;

public interface ICardService {
    /**
     *
     * @param mobileNumber - Mobile number of the customer
     */
    void createCard(String mobileNumber);

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return Card details based on a given mobile number
     */

    CardsDTO fetchCard(String mobileNumber);

    /**
     *
     * @param cardsDTO - CardsDTO object
     * @return boolean indicating if the update of card details is successful or not
     */
    boolean updateCard(CardsDTO cardsDTO);

    /**
     *
     * @param mobileNumber - Input Mobile number
     * @return boolean indicating if the delete of card details is successful of not
     */
    boolean deleteCard(String mobileNumber);

}
