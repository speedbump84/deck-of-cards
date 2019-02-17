package com.appian.deck.shuffle;

import java.util.List;

import com.appian.deck.card.Card;

/**
 * Extremely Simple card shuffle algorithm... so simple that it doesn't do
 * anything other than make sure the list of cards aren't null.
 * 
 * @author Christophe Santini
 *
 */
public class LazyShuffle implements ShuffleAlgorithm {

	public LazyShuffle() {
	}

	@Override
	public void shuffleCards(List<Card> cards) {
		if (cards == null) {
			throw new IllegalArgumentException("The list of cards to shuffle cannot be null");
		}

		return;
	}
}
