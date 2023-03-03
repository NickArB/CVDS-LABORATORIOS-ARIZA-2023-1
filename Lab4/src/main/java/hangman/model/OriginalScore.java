package hangman.model;

public class OriginalScore implements GameScore{
	private int points;
	
	public OriginalScore(){
		this.points = 100;
	}
	
    public int calculateScore(int correctCount, int incorrectCount){
		int ans = getPoints() - incorrectCount*10;
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