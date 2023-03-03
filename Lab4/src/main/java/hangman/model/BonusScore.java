package hangman.model;

public class BonusScore implements GameScore{
	private int points;
	
	public BonusScore(){
		this.points = 0;
	}
	
	public int calculateScore(int correctCount, int incorrectCount){
		int ans = getPoints() - (incorrectCount*5) + (correctCount*10);
		setPoints(ans);
		return (getPoints() == 0 | ans <= 0) ? 0 : ans;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public void setPoints(int newPoints){
		this.points = (newPoints > 0) ? newPoints : 0;
	}
}