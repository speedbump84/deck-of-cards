package com.appian.deck.card;

/**
 * Represents all possible card values
 * 
 * @author Christophe Santini
 *
 */
public enum CardValue {

	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11, "Jack"),
	QUEEN(12, "Queen"),
	KING(13, "King"),
	ACE_HIGH(14, "Ace"),
	ACE_LOW(1, "Ace");
	
	private String faceValue;
	private int value;
	
	private CardValue(int value, String faceValue) {
		this.value = value;
		this.faceValue = faceValue;
	}

	private CardValue(Integer value) {
		this(value, value.toString());
	}

	public String getFaceValue() {
		return faceValue;
	}

	public int getValue() {
		return value;
	}

	
	
	
}
