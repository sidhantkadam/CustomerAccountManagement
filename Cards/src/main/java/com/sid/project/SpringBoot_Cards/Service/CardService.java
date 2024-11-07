package com.sid.project.SpringBoot_Cards.Service;

import com.sid.project.SpringBoot_Cards.DTO.CardDTO;

public interface CardService
{
    void createCard(String mobileNumber);

    CardDTO fetchCard(String mobileNumber);

    boolean updateCard(CardDTO cardDto);

    boolean deleteCard(String mobileNumber);
}
