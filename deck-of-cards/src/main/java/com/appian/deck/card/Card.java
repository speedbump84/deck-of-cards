package com.appian.deck.card;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Represents a Card, including it's value and suite.
 * 
 * @author Christophe Santini
 *
 */
public class Card {
	private Suit suit;
	private CardValue value;

	public Card(CardValue value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public CardValue getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}
}
