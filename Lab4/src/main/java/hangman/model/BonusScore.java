package hangman.model;

public class BonusScore implements GameScore{
	private int points;
	
	public int calculateScore(int correctCount, int incorrectCount){
		return 1;
	}
	
	public int getPoints(){
		return this.points;
	}
}