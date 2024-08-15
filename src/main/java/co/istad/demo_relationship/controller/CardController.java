package co.istad.demo_relationship.controller;


import co.istad.demo_relationship.model.Card;
import co.istad.demo_relationship.model.request.CardRequest;
import co.istad.demo_relationship.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/card")
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<?> createAllCard(@RequestBody CardRequest cardRequest){
        Card card = cardService.createCard(cardRequest);
        return ResponseEntity.ok(card);
    }

    @GetMapping
    public ResponseEntity<?> getAllCard(){
        List<Card> card  = cardService.getAllCard();
        return ResponseEntity.ok(card);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCardById(@PathVariable Integer id){
        Card card = cardService.getCardById(id);
        return ResponseEntity.ok(card);
    }

    @PutMapping("/{id}")

    public ResponseEntity<?> updateCard(@PathVariable Integer id, @RequestBody CardRequest cardRequest){
        Card card = cardService.updateCard(id, cardRequest);
        return ResponseEntity.ok(card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Integer id){
        cardService.deleteCard(id);
        return ResponseEntity.ok("Card deleted");
    }
}
