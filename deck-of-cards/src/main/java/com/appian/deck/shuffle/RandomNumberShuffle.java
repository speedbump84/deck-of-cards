package com.appian.deck.shuffle;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.appian.deck.card.Card;

/**
 * Simple card shuffle algorithm that shuffles based on a random number generator.
 * 
 * @author Christophe Santini
 *
 */
public class RandomNumberShuffle implements ShuffleAlgorithm {

	private SecureRandom random;
	
	public RandomNumberShuffle() {
		random = new SecureRandom();
	}
	
	@Override
	public void shuffleCards(List<Card> cards) {
		if (cards == null) {
			throw new IllegalArgumentException("The list of cards to shuffle cannot be null");
		}
		
		if (cards.size() > 1) {
			
			List<Card> originalOrderList = new ArrayList<>(cards);
			
			int deckSize = cards.size();
			int displacedIndex;
			Card displacedCard;
			
			for (int i = 0; i < cards.size(); i++) {
				displacedIndex = random.nextInt(deckSize);
				displacedCard = cards.get(displacedIndex);
				cards.set(displacedIndex, cards.get(i));
				cards.set(i, displacedCard);
			}
			
			if (originalOrderList.equals(cards)) {
				shuffleCards(cards);
			}
		}
	}
}
