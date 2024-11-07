package com.sid.project.SpringBoot_Cards.Service;

import com.sid.project.SpringBoot_Cards.Constants.CardsConstants;
import com.sid.project.SpringBoot_Cards.DTO.CardDTO;
import com.sid.project.SpringBoot_Cards.Entity.Cards;
import com.sid.project.SpringBoot_Cards.Exception.CardAlreadyExistsException;
import com.sid.project.SpringBoot_Cards.Exception.ResourceNotFoundException;
import com.sid.project.SpringBoot_Cards.ModelMapper.ModelMapper;
import com.sid.project.SpringBoot_Cards.Repository.CardRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService
{
    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createCard(String mobileNumber)
    {

        Optional<Cards> cards = cardRepo.findByMobileNo(mobileNumber);
        if(cards.isPresent())
        {
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber "+mobileNumber);
        }
        cardRepo.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber)
    {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNo(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public CardDTO fetchCard(String mobileNumber)
    {
        Cards cards = cardRepo.findByMobileNo(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return modelMapper.cardEntityToDto(cards);
    }

    @Override
    public boolean updateCard(CardDTO cardDTO)
    {
        Cards ExistingCard = cardRepo.findByCardNumber(cardDTO.getCardNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Cards", "cardNo", cardDTO.getCardNumber()));
        Cards cards = modelMapper.cardsDtoToEntity(cardDTO);
        cards.setCardId(ExistingCard.getCardId());
        cardRepo.save(cards);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber)
    {
        Cards cards = cardRepo.findByMobileNo(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardRepo.deleteById(cards.getCardId());
        return true;
    }
}
