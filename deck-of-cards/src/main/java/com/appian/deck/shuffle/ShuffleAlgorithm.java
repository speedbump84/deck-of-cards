package com.appian.deck.shuffle;

import java.util.List;

import com.appian.deck.card.Card;

/**
 * Interface representing how a deck of cards may be shuffled
 * 
 * @author Christophe Santini
 *
 */
public interface ShuffleAlgorithm {
	public void shuffleCards(List<Card> cards);
}
