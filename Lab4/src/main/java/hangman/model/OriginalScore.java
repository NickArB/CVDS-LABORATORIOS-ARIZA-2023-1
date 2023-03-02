package hangman.model;

public class OriginalScore implements GameScore{
	private int points = 100;
	
    public int calculateScore(int correctCount, int incorrectCount){
		int ans = getPoints() - incorrectCount*10;
		return (getPoints() == 0 | ans <= 0) ? 0 : ans;
	}
	
	public int getPoints(){
		return this.points;
	}
}