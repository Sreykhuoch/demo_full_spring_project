package co.istad.demo_relationship.service.serviceImpl;

import co.istad.demo_relationship.model.Card;
import co.istad.demo_relationship.model.request.CardRequest;
import co.istad.demo_relationship.repository.CardRepository;
import co.istad.demo_relationship.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    @Override
    public Card createCard(CardRequest cardRequest) {
        Card card = new Card();
        card.setNumber(cardRequest.getCardNumber());
        cardRepository.save(card);
        return card;


    }

    @Override
    public List<Card> getAllCard() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCardById(Integer id) {
        Card card = cardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("card id is not found")
        );
       return card;
    }

    @Override
    public Card updateCard(Integer id, CardRequest cardRequest) {
        Card card = cardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("card id is not found")
        );
        card.setNumber(cardRequest.getCardNumber());
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Integer id) {
        Card card = cardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("card id is not found")
        );
        cardRepository.delete(card);
    }
}
