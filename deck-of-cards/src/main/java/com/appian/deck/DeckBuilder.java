package com.appian.deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import com.appian.deck.card.Card;
import com.appian.deck.card.CardValue;
import com.appian.deck.card.Suit;
import com.appian.deck.shuffle.RandomNumberShuffle;
import com.appian.deck.shuffle.ShuffleAlgorithm;

/**
 * Builder that handles the construction of poker decks, including an up front
 * decision on whether Aces are high or low, and which shuffle algorithm the
 * deck should use.
 * 
 * @author Christophe Santini
 *
 */
public class DeckBuilder {

	private static final Set<CardValue> acsHighValues = Collections
			.unmodifiableSet(cardValuesWithout(CardValue.ACE_LOW));
	private static final Set<CardValue> acsLowValues = Collections
			.unmodifiableSet(cardValuesWithout(CardValue.ACE_HIGH));

	private static final ShuffleAlgorithm defaultShuffleAglorithm = new RandomNumberShuffle();

	public static Deck newPokerDeck(boolean acesHigh) {
		return newPokerDeck(acesHigh, defaultShuffleAglorithm);
	}

	public static Deck newPokerDeck(boolean acesHigh, ShuffleAlgorithm shuffleAlgorithm) {

		List<Card> cards = new ArrayList<>();

		Set<CardValue> cardValues = acesHigh ? acsHighValues : acsLowValues;

		for (Suit suit : Suit.values()) {
			for (CardValue cardValue : cardValues) {
				cards.add(new Card(cardValue, suit));
			}
		}

		return new Deck(cards, shuffleAlgorithm);
	}

	private static Set<CardValue> cardValuesWithout(CardValue... cardValues) {
		Set<CardValue> valueSet = EnumSet.allOf(CardValue.class);
		valueSet.removeAll(Arrays.asList(cardValues));
		return valueSet;
	}

}
