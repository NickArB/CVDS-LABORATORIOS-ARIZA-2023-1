### Escuela colombiana de ingenieria Julio Garavito
### Laboratorio 4
#### Estudiante: *Nicolás Ariza Barbosa*
1. A partir del código existente, implemente sólo los cascarones del modelo antes indicado. Haga la especificación de los métodos calculateScore (de las tres variantes de GameScore), a partir de las especificaciones generales dadas anteriormente. Recuerde tener en cuenta: @pre, @pos, @param, @throws.
##### Interfaz GameScore
```
package hangman.model;

public interface GameScore{
	/**
	*	Method that calculates the score of the player based in how many
	*	correct or incorrect letters he guessed.
	*	@Param correctCount The number of letters that the player have asserted.
	*	@Param ncorrectCount The number of letters that the player have failed guessing.
	*	@Return The current score of the player based of his positive or negative points.
	*/
	public int calculateScore(int correctCount, int incorrectCount);
	
	/**
	*	Method that returns the current score of a player.
	*	@Return The current score of the player.
	*/
	public int getPoints();
}
```
##### Clase OriginalScore
```
package hangman.model;

public class OriginalScore implements GameScore{
	private int points = 100;
	
	public OriginalScore(){
		this.points = 100;
	}
	
	/**
	*	Method that calculates the score of the player based in how many
	*	correct or incorrect letters he guessed.
	*	@Param ncorrectCount The number of letters that the player have failed guessing.
	*	@Return The current score of the player based of his positive or negative points.
	*/
    public int calculateScore(int incorrectCount){
		return 1;
	}
	
	/**
	*	Method that returns the current score of a player.
	*	@Return The current score of the player.
	*/
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
	
	public BonusScore(){
		this.points = 0;
	}
	
	/**
	*	Method that calculates the score of the player based in how many
	*	correct or incorrect letters he guessed.
	*	@Param correctCount The number of letters that the player have asserted.
	*	@Param ncorrectCount The number of letters that the player have failed guessing.
	*	@Return The current score of the player based of his positive or negative points.
	*/
	public int calculateScore(int correctCount, int incorrectCount){
		return 1;
	}
	
	/**
	*	Method that returns the current score of a player.
	*	@Return The current score of the player.
	*/
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
	
	public PowerScore(){
		this.points = 0;
	}
	
	/**
	*	Method that calculates the score of the player based in how many
	*	correct or incorrect letters he guessed.
	*	@Param correctCount The number of letters that the player have asserted.
	*	@Param ncorrectCount The number of letters that the player have failed guessing.
	*	@Return The current score of the player based of his positive or negative points.
	*/
	public int calculateScore(int correctCount, int incorrectCount){
		return 1;
	}
	
	/**
	*	Method that returns the current score of a player.
	*	@Return The current score of the player.
	*/
	public int getPoints(){
		return this.points;
	}
}
```
2. Actualice el archivo pom.xml e incluya las dependencias para la ultima versión de JUnit y la versión del compilador de Java a la versión 8.
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>edu.eci.pdsw</groupId>
    <artifactId>Hangman</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <showDeprecation>true</showDeprecation>
                </configuration>
            </plugin>
        </plugins>
    </build>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>com.google.inject</groupId>
            <artifactId>guice</artifactId>
            <version>4.0</version>
        </dependency>
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13.2</version>
			<scope>test</scope>
		</dependency>
    </dependencies>
</project>
```
3. Teniendo en cuenta dichas especificaciones, en la clase donde se implementarán las pruebas (GameScoreTest), en los comentarios iniciales, especifique las clases de equivalencia para las tres variantes de GameScore, e identifique condiciones de frontera.
```
package hangman.model;
import org.junit.Assert;
import org.junit.Test;

public class GameScoreTest{
	//	Se asume que en todos los modos el puntaje minimo debe ser exactamente 0 y no puede decrecer más.
	//
	//	OriginalScore:		- La cantidad de letras incorrectas	por el multiplicador de elecciones erroneas 
	//							(x10) sea menor al puntaje acumulado, en este caso deberia retornar el puntaje
	//							actual positivo y menor a cien (100).
	//						- La cantidad de letras incorrectas por el multiplicador de elecciones erroneas 
	//							(x10) sea exactamente igual al puntaje acumulado, en dicho
	//							caso deberia retornar un puntaje igual a 0.
	//						- La cantidad de letras incorrectas por el multiplicador de elecciones erroneas 
	//							(x10) sea mayor al puntaje acumulado, en dicho caso deberia retornar un puntaje 
	//							igual a 0.
	//						- La cantidad de letras incorrectas sea negativa, en dicho
	//							caso deberia arrojarse una excepcion sobre el valor invalido.
	//						- La cantidad de letras correctas sea negativa, en dicho
	//							caso deberia arrojarse una excepcion sobre el valor invalido.
	//						- La cantidad de letras correctas sea mayor a 0, en dado caso
	//							el puntaje del jugador no deberia verse afectado ya que las
	//							letras acertadas no cuentan para adicionar puntaje en este modo.
	//
	//	BonusScore:			- La cantidad de letras incorrectas sea exactamente una (1) al inicio,
	//							en este caso el puntaje retornado deberia ser igual a 0.
	//						- Con un puntaje acumulado mayor a 0, la cantidad de letras incorrectas 
	//							por el multiplicador de elecciones erroneas (x5) sea menor al puntaje 
	//							acumulado. En este caso el puntaje retornado deberia ser mayor a 0.
	//						- Con un puntaje acumulado mayor a 0, la cantidad de letras incorrectas 
	//							por el multiplicador de elecciones erroneas (x5) sea mayor al puntaje 
	//							acumulado. En este caso el puntaje retornado deberia ser igual a 0.
	//						- La cantidad de letras correctas sea mayor a 0, en este caso el puntaje
	//							acumulado debera verse aumentado sumando dicha cantidad de letras por el 
	//							multiplicador de letras correctas (x10) sin un limite definido de puntos.

	//
	//	PowerBonusScore:	- La cantidad de letras incorrectas sea uno o mayor al inicio,
	//							en este caso el puntaje retornado deberia ser igual a 0.
	//						- Con un puntaje acumulado mayor a 0, la cantidad de letras incorrectas 
	//							por el multiplicador de elecciones erroneas (x8) sea menor al puntaje 
	//							acumulado. En este caso el puntaje retornado deberia ser mayor a 0.
	//						- Con un puntaje acumulado mayor a 0, la cantidad de letras incorrectas 
	//							por el multiplicador de elecciones erroneas (x8) sea mayor al puntaje 
	//							acumulado. En este caso el puntaje retornado deberia ser igual a 0.
	//						- La cantidad de letras correctas sea mayor a 0, en este caso el puntaje
	//							acumulado debera verse aumentado sumando dicha cantidad de letras por el 
	//							multiplicador de letras correctas (x5^i) no superando mas de 500 puntos.
	//						- El puntaje es exactamente 500 y el jugador consigue acertar otra letra.
	//							En este caso el puntaje acumulado deberia mantenerse en 500.
}
```