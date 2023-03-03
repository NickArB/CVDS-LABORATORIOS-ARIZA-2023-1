### Escuela colombiana de ingenieria Julio Garavito
### Laboratorio 4
#### Estudiante: *Nicolás Ariza Barbosa*
1. A partir del código existente, implemente sólo los cascarones del modelo antes indicado. Haga la especificación de los métodos calculateScore (de las tres variantes de GameScore), a partir de las especificaciones generales dadas anteriormente. Recuerde tener en cuenta: @pre, @pos, @param, @throws.
##### Interfaz GameScore
```
package hangman.model;

public interface GameScore{
	public int calculateScore(int correctCount, int incorrectCount);
	
	public int getPoints();
	
	public void setPoints(int newPoints);
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
	
    public int calculateScore(int incorrectCount){
		return 1;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public void setPoints(int newPoints){
		this.points = newPoints;
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
	
	public int calculateScore(int correctCount, int incorrectCount){
		return 1;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public void setPoints(int newPoints){
		this.points = newPoints;
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
	
	public int calculateScore(int correctCount, int incorrectCount){
		return 1;
	}
	
	/**
	*	Method that calculates the power of five according with the number
	*	of correct words that the player have guessed correctly.
	*	@Param powerValue It's the number of correct words guessed.
	*	@Return Five power to the number of correct words guessed.
	*/
	private int setNewPowerScore(int powerValue){
		return 1;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public void setPoints(int newPoints){
		this.points = newPoints;
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
3. Teniendo en cuenta dichas especificaciones, en la clase donde se implementarán las pruebas (GameScoreTest), en los comentarios iniciales, especifique las clases de equivalencia para las tres variantes de GameScore, e identifique condiciones de frontera. Para cada clase de equivalencia y condición de frontera, implemente una prueba utilizando JUnit.
```
package hangman.model;
import org.junit.Assert;
import org.junit.Test;

public class GameScoreTest{
	//	OriginalScore:	
	
	// - La cantidad de letras incorrectas	por el multiplicador de elecciones erroneas 
	//	(x10) sea menor al puntaje acumulado, en este caso deberia retornar el puntaje
	//	actual positivo y menor a cien (100).
	@Test
	public void Os_Should_ReturnPositivePoints_When_PointsBiggerThanPenalization() {
		// Arrange
		OriginalScore scoreMode = new OriginalScore();
		int expected = 90;
		// Act
		int result = scoreMode.calculateScore(0, 1);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	- La cantidad de letras incorrectas por el multiplicador de elecciones erroneas 
	//	(x10) sea exactamente igual al puntaje acumulado, en dicho
	//	caso deberia retornar un puntaje igual a 0.
	@Test
	public void Os_Should_ReturnZeroPoints_When_PointsEqualsToPenalization() {
		// Arrange
		OriginalScore scoreMode = new OriginalScore();
		int expected = 0;
		// Act
		int result = scoreMode.calculateScore(0, 10);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	- La cantidad de letras incorrectas por el multiplicador de elecciones erroneas 
	//	(x10) sea mayor al puntaje acumulado, en dicho caso deberia retornar un puntaje 
	//	igual a 0.
	@Test
	public void Os_Should_ReturnZeroPoints_When_PointsSmallerThanPenalization() {
		// Arrange
		OriginalScore scoreMode = new OriginalScore();
		int expected = 0;
		// Act
		int result = scoreMode.calculateScore(0, 11);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	- La cantidad de letras correctas sea mayor a 0, en dado caso
	//	el puntaje del jugador no deberia verse afectado ya que las
	//	letras acertadas no cuentan para adicionar puntaje en este modo.
	@Test
	public void Os_Should_ReturnSamePoints_When_HaveCorrectWords() {
		// Arrange
		OriginalScore scoreMode = new OriginalScore();
		int expected = 100;
		// Act
		int result = scoreMode.calculateScore(1, 0);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	BonusScore:	
	
	//	- La cantidad de letras incorrectas sea uno o mayor al inicio,
	//	en este caso el puntaje retornado deberia ser igual a 0.
	@Test
	public void Bs_Should_ReturnZeroPoints_When_BadLetterStarting() {
		// Arrange
		BonusScore scoreMode = new BonusScore();
		int expected = 0;
		// Act
		int result = scoreMode.calculateScore(0, 3);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	- Con un puntaje acumulado mayor a 0, la cantidad de letras incorrectas 
	//	por el multiplicador de elecciones erroneas (x5) sea menor al puntaje 
	//	acumulado. En este caso el puntaje retornado deberia ser mayor a 0.
	@Test
	public void Bs_Should_ReturnPositivePoints_When_PointsBiggerThanPenalization() {
		// Arrange
		BonusScore scoreMode = new BonusScore();
		int expected = 30;
		// Act
		int result = scoreMode.calculateScore(4, 2);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	- Con un puntaje acumulado mayor a 0, la cantidad de letras incorrectas 
	//	por el multiplicador de elecciones erroneas (x5) sea mayor al puntaje 
	//	acumulado. En este caso el puntaje retornado deberia ser igual a 0.
	@Test
	public void Bs_Should_ReturnZeroPoints_When_PointsSmallerThanPenalization() {
		// Arrange
		BonusScore scoreMode = new BonusScore();
		int expected = 0;
		// Act
		int result = scoreMode.calculateScore(2, 4);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	- La cantidad de letras correctas sea mayor a 0, en este caso el puntaje
	//	acumulado debera verse aumentado sumando dicha cantidad de letras por el 
	//	multiplicador de letras correctas (x10) sin un limite definido de puntos.
	@Test
	public void Bs_Should_ReturnMorePoints_When_HaveGuessedCorrectLetters() {
		// Arrange
		BonusScore scoreMode = new BonusScore();
		int expected = 30;
		// Act
		int result = scoreMode.calculateScore(3, 0);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	PowerBonusScore:	
	
	//	- La cantidad de letras incorrectas sea uno o mayor al inicio,
	//	en este caso el puntaje retornado deberia ser igual a 0.
	@Test
	public void Pbs_Should_ReturnZeroPoints_When_BadLetterStarting() {
		// Arrange
		PowerBonusScore scoreMode = new PowerBonusScore();
		int expected = 0;
		// Act
		int result = scoreMode.calculateScore(0, 3);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	- Con un puntaje acumulado mayor a 0, la cantidad de letras incorrectas 
	//	por el multiplicador de elecciones erroneas (x8) sea menor al puntaje 
	//	acumulado. En este caso el puntaje retornado deberia ser mayor a 0.
	@Test
	public void Pbs_Should_ReturnPositivePoints_When_PointsBiggerThanPenalization() {
		// Arrange
		PowerBonusScore scoreMode = new PowerBonusScore();
		int expected = 17;
		// Act
		int result = scoreMode.calculateScore(2, 1);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	- Con un puntaje acumulado mayor a 0, la cantidad de letras incorrectas 
	//	por el multiplicador de elecciones erroneas (x8) sea mayor al puntaje 
	//	acumulado. En este caso el puntaje retornado deberia ser igual a 0.
	@Test
	public void Pbs_Should_ReturnZeroPoints_When_PointsSmallerThanPenalization() {
		// Arrange
		PowerBonusScore scoreMode = new PowerBonusScore();
		int expected = 0;
		// Act
		int result = scoreMode.calculateScore(1, 2);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	- La cantidad de letras correctas sea mayor a 0, en este caso el puntaje
	//	acumulado debera verse aumentado sumando dicha cantidad de letras por el 
	//	multiplicador de letras correctas (x5^i). En este caso el puntaje acumulado
	//	del jugador deberia aumentar.
	@Test
	public void Pbs_Should_ReturnMorePoints_When_HaveCorrectWords() {
		// Arrange
		PowerBonusScore scoreMode = new PowerBonusScore();
		int expected = 125;
		// Act
		int result = scoreMode.calculateScore(3, 0);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	//	- La cantidad de letras acertadas por el multiplicador de letras correctas
	//		(x5^i) supera el maximo valor de 500. En este caso el puntaje acumulado 
	//		deberia mantenerse en 500.
	@Test
	public void Pbs_Should_StopIn500Points() {
		// Arrange
		PowerBonusScore scoreMode = new PowerBonusScore();
		int expected = 500;
		// Act
		int result = scoreMode.calculateScore(5, 0);
		// Assert
		Assert.assertEquals(expected, result);
	}

}
```
4. Realice la implementación de los 'cascarones' realizados anteriormente. Asegúrese que todas las pruebas unitarias creadas en los puntos anteriores se ejecutan satisfactoriamente.
##### Clase OriginalScore
```
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
```
##### Clase BonusScore
```
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
```
##### Clase PowerBonusScore
```
package hangman.model;

public class PowerBonusScore implements GameScore{
	private int points;
	private int power;
	
	public PowerBonusScore(){
		this.points = 0;
	}
	
	public int calculateScore(int correctCount, int incorrectCount){
		int score = setNewPowerScore(correctCount);
		int ans = getPoints() - (incorrectCount*8) + (score);
		setPoints(ans);
		return (getPoints() == 0 | ans <= 0) ? 0 : (ans < 500) ? ans : 500;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	/**
	*	Method that calculates the power of five according with the number
	*	of correct words that the player have guessed correctly.
	*	@Param powerValue It's the number of correct words guessed.
	*	@Return Five power to the number of correct words guessed.
	*/
	private int setNewPowerScore(int powerValue){
		int result = 1;
		int temp = powerValue;
		while (temp > 0){
			result *= 5;
			temp -= 1;
		}
		return (result == 1) ? 0 : result;
	}
	
	public void setPoints(int newPoints){
		this.points = (newPoints > 0) ? newPoints : 0;
	}
}
```