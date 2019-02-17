package com.appian.deck;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.appian.deck.card.Card;
import com.appian.deck.card.CardValue;
import com.appian.deck.card.Suit;
import com.appian.deck.shuffle.RandomNumberShuffle;
import com.appian.deck.shuffle.ShuffleAlgorithm;

/**
 * Represents a deck of cards. For the purposes of this exercise, decks are
 * self-shuffling and self-dealing. A different implementation may expose more
 * operations around the insertion and removal of cards in the deck to not
 * require the shuffle algorithm to have access to the underlying list of cards.
 * The {@link Deck#shuffle() and {@link Deck#dealOneCard()} methods could then
 * exist in a Dealer class.
 * 
 * @author Christophe Santini
 *
 */
public class Deck {
	private List<Card> cards;
	private ShuffleAlgorithm shuffleAlgorithm;

	public Deck(List<Card> cards, ShuffleAlgorithm shuffleAlgorithm) {
		this.cards = cards;
		this.shuffleAlgorithm = shuffleAlgorithm;
	}

	public Deck(List<Card> cards) {
		this(cards, new RandomNumberShuffle());
	}

	/**
	 * 
	 * @return The number of cards currently in the deck
	 */
	public int size() {
		return cards.size();
	}


	/**
	 * 
	 * @param cardValue
	 * @param cardSuit
	 * @return True if a card matching cardValue and cardSuit exists
	 */
	public boolean exists(CardValue cardValue, Suit cardSuit) {
		return cards.indexOf(new Card(cardValue, cardSuit)) != -1;
	}
	
	
	/**
	 * Shuffles a card according to the deck's suffling algorithm
	 */
	public void shuffle() {
		shuffleAlgorithm.shuffleCards(cards);
	}

	/**
	 * Pops a card off the top of the list. Returns an empty optional if there are
	 * no cards left in the deck.
	 * 
	 * @return A card if there are any cards left
	 */
	public Optional<Card> dealOneCard() {
		if (size() > 0) {
			return Optional.of(cards.remove(0));
		}
		return Optional.empty();
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "shuffleAlgorithm");
	}

}
