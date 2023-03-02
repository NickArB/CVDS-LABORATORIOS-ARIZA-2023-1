### Escuela colombiana de ingenieria Julio Garavito
### Laboratorio 4
#### Estudiante: *Nicolás Ariza Barbosa*
1. A partir del código existente, implemente sólo los cascarones del modelo antes indicado.
##### Interfaz GameScore
```
package hangman.model;

public interface GameScore{
	public int calculateScore(int correctCount, int incorrectCount);
	public int getPoints();
}
```
##### Clase OriginalScore
```
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
```
##### Clase BonusScore
```
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
```
##### Clase PowerScore
```
package hangman.model;

public class PowerScore implements GameScore{
    private int points;
    
	public int calculateScore(int correctCount, int incorrectCount){
		return 1;
	}
	
	public int getPoints(){
		return this.points;
	}
}
```