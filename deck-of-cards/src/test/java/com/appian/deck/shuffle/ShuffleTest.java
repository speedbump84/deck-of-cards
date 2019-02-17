package com.appian.deck.shuffle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.appian.deck.Deck;
import com.appian.deck.DeckBuilder;
import com.appian.deck.card.Card;
import com.appian.deck.card.CardValue;
import com.appian.deck.card.Suit;

@RunWith(BlockJUnit4ClassRunner.class)
public class ShuffleTest {

	@Test
	public void lazyShuffleDoesNothing() {
		
		ShuffleAlgorithm lazyShuffle = new LazyShuffle();
		List<Card> cardList = getCardList();
		List<Card> shuffledCardList = new ArrayList<>(cardList);
		
		assertEquals(cardList, shuffledCardList);
		
		lazyShuffle.shuffleCards(shuffledCardList);
		
		assertEquals(cardList, shuffledCardList);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void lazyShuffleErrorsOnNull() {
		ShuffleAlgorithm lazyShuffle = new LazyShuffle();
		lazyShuffle.shuffleCards(null);
	}

	@Test
	public void randomShuffleShufflesCards() {
		
		ShuffleAlgorithm randomShuffle = new RandomNumberShuffle();
		List<Card> cardList = getCardList();
		List<Card> shuffledCardList = new ArrayList<>(cardList);
		
		assertEquals(cardList, shuffledCardList);
		randomShuffle.shuffleCards(shuffledCardList);
		assertFalse(cardList.equals(shuffledCardList));
	}

	@Test
	public void randomShuffleSmallList() {
		ShuffleAlgorithm randomShuffle = new RandomNumberShuffle();
		List<Card> cardList = new ArrayList<>();
		List<Card> shuffledList = new ArrayList<>();
		
		Card twoOfClubs = new Card(CardValue.TWO, Suit.CLUBS);
		Card threeOfDiamonds= new Card(CardValue.THREE, Suit.DIAMONDS);
		
		randomShuffle.shuffleCards(shuffledList);
		
		assertEquals(cardList, shuffledList);
		
		cardList.add(twoOfClubs);
		shuffledList.add(twoOfClubs);
		randomShuffle.shuffleCards(shuffledList);
		assertEquals(cardList, shuffledList);
		
		cardList.add(threeOfDiamonds);
		shuffledList.add(threeOfDiamonds);
		randomShuffle.shuffleCards(shuffledList);
		
		assertFalse(cardList.equals(shuffledList));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void RandomNumberShuffleErrorsOnNull() {
		ShuffleAlgorithm randomShuffle = new RandomNumberShuffle();
		randomShuffle.shuffleCards(null);
	}

	
	
	private List<Card> getCardList() {
		Deck deck = DeckBuilder.newPokerDeck(false);
	
		List<Card> cardList = new ArrayList<Card>();
		
		Optional<Card> card;
		
		while ( (card = deck.dealOneCard()).isPresent()) {
			cardList.add(card.get());
		}
		
		return cardList;
	}
	
}
