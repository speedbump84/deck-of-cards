package com.appian.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.appian.deck.shuffle.LazyShuffle;
import com.appian.deck.shuffle.RandomNumberShuffle;

@RunWith(BlockJUnit4ClassRunner.class)
public class DeckTest {

	@Test
	public void dealOneCardEmptiesDeck() {

		Deck deck = DeckBuilder.newPokerDeck(true);
		assertTrue(deck.size() == 52);
		
		for (int deckCount = 52; deckCount > 0; deckCount--) {
			assertTrue(deckCount == deck.size());
			assertTrue(deck.dealOneCard().isPresent());
		}
		assertTrue(0 == deck.size());
		assertFalse(deck.dealOneCard().isPresent());
	}

	@Test
	public void defaultDeckShuffle() {
		Deck unshuffled = DeckBuilder.newPokerDeck(true);
		Deck shuffled = DeckBuilder.newPokerDeck(true);

		assertEquals(unshuffled, shuffled);

		shuffled.shuffle();

		assertTrue(52 == shuffled.size());
		
		assertFalse(shuffled.equals(unshuffled));
	}
	
	@Test
	public void deckShufflesWhileDealing() {
		Deck deck = DeckBuilder.newPokerDeck(true);
		
		for (int deckCount = 52; deckCount > 0; deckCount--) {
			assertTrue(deckCount == deck.size());
			assertTrue(deck.dealOneCard().isPresent());
			deck.shuffle();
		}
		assertTrue(0 == deck.size());
		assertFalse(deck.dealOneCard().isPresent());
	}
	
	@Test
	public void equalsIgnoresShuffleAlg() {
		Deck randomShuffleDeck = DeckBuilder.newPokerDeck(true, new RandomNumberShuffle());
		Deck lazyShuffleDeck = DeckBuilder.newPokerDeck(true, new LazyShuffle());
	
		assertEquals(randomShuffleDeck, lazyShuffleDeck);
		
		lazyShuffleDeck.dealOneCard();
		
		assertFalse(randomShuffleDeck.equals(lazyShuffleDeck));
		
	}
	
	
}
