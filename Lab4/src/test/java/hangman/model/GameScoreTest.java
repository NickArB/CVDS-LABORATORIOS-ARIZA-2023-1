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