package hangman.model;

public class OriginalScore implements GameScore{
	private int points;
	
    public int calculateScore(int correctCount, int incorrectCount){
		return 1;
	}
	
	public int getPoints(){
		return this.points;
	}
}