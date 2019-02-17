package com.appian.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.appian.deck.card.Card;
import com.appian.deck.card.CardValue;
import com.appian.deck.card.Suit;

@RunWith(BlockJUnit4ClassRunner.class)
public class DeckBuilderTest {

	@Test
	public void testDeckBuilder() {
		Deck deck = DeckBuilder.newPokerDeck(true);
		assertCardValuesNotInDeck(deck, CardValue.ACE_LOW);
		assertCardValuesInDeck(deck, CardValue.ACE_HIGH);

		Card firstCard = deck.dealOneCard().get();

		assertEquals(firstCard.getValue(), CardValue.TWO);
		assertEquals(firstCard.getSuit(), Suit.HEARTS);

		deck = DeckBuilder.newPokerDeck(false);
		assertCardValuesNotInDeck(deck, CardValue.ACE_HIGH);
		assertCardValuesInDeck(deck, CardValue.ACE_LOW);

	}

	private void assertCardValuesNotInDeck(Deck deck, CardValue... cardValues) {
		for (Suit suit : Suit.values()) {
			for (CardValue cardValue : cardValues) {
				assertFalse(deck.exists(cardValue, suit));
			}
		}
	}

	private void assertCardValuesInDeck(Deck deck, CardValue... cardValues) {
		for (Suit suit : Suit.values()) {
			for (CardValue cardValue : cardValues) {
				assertTrue(deck.exists(cardValue, suit));
			}
		}
	}

}
