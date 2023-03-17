package edu.eci.cvds.servlet;

import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ApplicationScoped;

@ManagedBean(name = "guessBean")
@SessionScoped
public class GuessBean{
	private int currentNumberGuess;
	private int attempts;
	private int prize;
	private String[] gameStates = new String[]{"Winner of ", "You Loose", "Gotta keep up"};
	private String gameState;
	private Random guessNumber = new Random();
	
	
	public GuessBean(){
		this.gameState = gameStates[2];
		setPrize(30000);
		setAttempts(5);
		setNewNumber();
	}
	
	public void gues(int numberChoosen){
		this.prize = (numberChoosen == getCurrentGuessNumber()) ?  (getPrize() + 100000) : (getPrize() - 10000);
		setAttempts(getAttempts() - 1);
		validateGameState();
	}
	
	public void reset(){
		this.gameState = gameStates[2];
		setPrize(30000);
		setAttempts(5);
		setNewNumber();
	}
	
	private void validateGameState(){
		if (getPrize() <= 0 || getAttempts() <= 0){
			setGameState("L");
		}else{
			setGameState("W");
		}
	}
	
	public void setNewNumber(){
		this.currentNumberGuess = guessNumber.nextInt(5)+1;
	}
	
	public void setAttempts(int newAttempts) {
		this.attempts = newAttempts;
	}
	
	public void setPrize(int newPrize){
		this.prize = newPrize;
	}
	
	public void setGameState(String newGameState){
		this.gameState = (newGameState.equals("W")) ? gameStates[0] + "$" + getPrize(): gameStates[1];
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