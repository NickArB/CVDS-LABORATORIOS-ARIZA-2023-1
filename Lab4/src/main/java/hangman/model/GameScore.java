package hangman.model;

public interface GameScore{
	/**
	*	Method that calculates the score of the player based in how many
	*	correct or incorrect letters he guessed.
	*	@Param correctCount The number of letters that the player have asserted.
	*	@Param ncorrectCount The number of letters that the player have failed guessing.
	*	@Return The current score of the player based of his positive or negative points.
	*/
	public int calculateScore(int correctCount, int incorrectCount);
	
	/**
	*	Method that returns the current score of a player.
	*	@Return The current score of the player.
	*/
	public int getPoints();
}