package co.istad.demo_relationship.service;

import co.istad.demo_relationship.model.Card;
import co.istad.demo_relationship.model.request.CardRequest;

import java.util.List;

public interface CardService {
    Card createCard(CardRequest cardRequest);

    List<Card> getAllCard();

    Card getCardById(Integer id);

    Card updateCard(Integer id, CardRequest cardRequest);

    void deleteCard(Integer id);
}
