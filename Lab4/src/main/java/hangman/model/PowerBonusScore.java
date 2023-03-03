package hangman.model;

public class PowerBonusScore implements GameScore{
	private int points;
	private int power;
	
	public PowerBonusScore(){
		this.points = 0;
	}
	
	public int calculateScore(int correctCount, int incorrectCount){
		int score = setNewPowerScore(correctCount);
		int ans = getPoints() - (incorrectCount*8) + (score);
		setPoints(ans);
		return (getPoints() == 0 | ans <= 0) ? 0 : (ans < 500) ? ans : 500;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	/**
	*	Method that calculates the power of five according with the number
	*	of correct words that the player have guessed correctly.
	*	@Param powerValue It's the number of correct words guessed.
	*	@Return Five power to the number of correct words guessed.
	*/
	private int setNewPowerScore(int powerValue){
		int result = 1;
		int temp = powerValue;
		while (temp > 0){
			result *= 5;
			temp -= 1;
		}
		return (result == 1) ? 0 : result;
	}
	
	public void setPoints(int newPoints){
		this.points = (newPoints > 0) ? newPoints : 0;
	}
}