package hangman.model;

public interface GameScore{
	public int calculateScore(int correctCount, int incorrectCount);
	
	public int getPoints();
	
	public void setPoints(int newPoints);
}