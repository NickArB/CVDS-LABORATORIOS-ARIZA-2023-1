package hangman.model;

public class PowerScore implements GameScore{
	private int points;
	private int power;
	
	public PowerScore(){
		this.points = 0;
		this.power = 0;
	}
	
	/**
	*	Method that calculates the score of the player based in how many
	*	correct or incorrect letters he guessed.
	*	@Param correctCount The number of letters that the player have asserted.
	*	@Param ncorrectCount The number of letters that the player have failed guessing.
	*	@Return The current score of the player based of his positive or negative points.
	*/
	public int calculateScore(int correctCount, int incorrectCount){
		int ans = getPoints() - incorrectCount*10;
		setPoints(ans);
		return (getPoints() == 0 | ans <= 0) ? 0 : ans;
	}
	
	/**
	*	Method that returns the current score of a player.
	*	@Return The current score of the player.
	*/
	public int getPoints(){
		return this.points;
	}
	
	public int getPowerValue(){
		return this.power;
	}
	
	public void addOneToPower(){
		this.power += 1;
	}
	
	public void setPoints(int newPoints){
		this.points = (newPoints > 0) ? newPoints : 0;
	}
}