package com.example.palacelayouttesting2;

import android.util.Log;

/**
 * @author Maximilian
 * <p>
 * This class is an enumeration for the Card.java class. It represents the suit of a card object. The
 * only reason there are integers associated with the various suit enumerations, is because it allows
 * us to create the PalaceGameState deck of cards using nexted for loops (see "initialize_the_deck()" in
 * PalaceGameState.java for an example).
 */
public enum Suit
{
	SPADES(1), CLUBS(2), DIAMONDS(3), HEARTS(4);

	public static final int SPADES_INT =   1;
	public static final int CLUBS_INT =    2;
	public static final int DIAMONDS_INT = 3;
	public static final int HEARTS_INT =   4;

	private int suit_num;

	Suit(int suit_num)
	{
		this.suit_num = suit_num;
	}//END: Suit() enum constructor


	public int get_suit_num()
	{
		return this.suit_num;
	}//END: get_suit_num() method

	public static Suit int_to_suit(int num)
	{
		switch(num)
		{
			case SPADES_INT:   return SPADES;
			case CLUBS_INT:    return CLUBS;
			case DIAMONDS_INT: return DIAMONDS;
			case HEARTS_INT:   return HEARTS;

			default:
				Log.d("Suit.java:34", "ERROR: Incorrect integer passed to the 'int_to_suit()' function");
				return null;
		}
	}//END: int_to_suit() function
}//END: Suit enum
