package Game;
/**
 * Keeps track of the player's score.
 *
 * Provides methods to get the current score and increment it.
 */

public class HUDModel {
	
	private int score = 0;
	
	
	//Returns score variable.
	public int getScore()
	{
		return score;
	}
	
	//Increment Score
	public void incScore()
	{
		this.score += 1;
	}
}






