package edu.eci.cvds.servlet;

public class BackingBean{
	private int currentNumberGuess;
	private int attempts;
	private int prize;
	private String[] gameStates = new String[]{"Winner of ", "You Loose"};
	private String gameState;
	
	public BackingBean(){
	}
	
	public void setNewNumber(int newNumber){
		this.currentNumberGuess = newNumber;
	}
	
	public void setAttempts(int newAttempts) {
		this.attempts = newAttempts;
	}
	
	public void setPrize(int newPrize){
		this.prize = newPrize;
	}
	
	public void setGameState(String newGameState){
		this.gameState = (newGameState.equals("W")) ? gameStates[0] + getPrize() : gameStates[1];
	}
	
	public int getCurrentGuessNumber(){
		return currentNumberGuess;
	}
	
	public int getAttempts(){
		return attempts;
	}
	
	public int getPrize(){
		return prize;
	}
	
	public String getGameState(){
		return gameState;
	}
}