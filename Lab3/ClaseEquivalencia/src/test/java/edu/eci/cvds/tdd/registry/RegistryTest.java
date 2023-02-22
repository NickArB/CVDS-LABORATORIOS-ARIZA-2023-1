package edu.eci.cvds.tdd.registry;
import main.java.edu.eci.cvds.tdd.registry.*;
import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
	private Registry registry = new Registry();
	private Person person = new Person("Nick", 1001, 21, Gender.MALE, true);
	private RegisterResult expected; 
		
	@ParameterizedTest()
	@ValueSource(ages = {18, 19, 100})
	public void Should_Allow_18_Or_More(int age) {
		// Arrange
		person.setAge(age);
		expected = RegisterResult.VALID;
		// Act
		RegisterResult result = registry.registerVoter(person);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	@ParameterizedTest()
	@ValueSource(ages = {17, 10, 0})
	public void Should_Not_Allow_Under_18_Or_Less(int age) {
		// Arrange
		person.setAge(age);
		expected = RegisterResult.UNDERAGE;
		// Act
		RegisterResult result = registry.registerVoter(person);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	@ParameterizedTest()
	@ValueSource(ages = {-10, 210})
	public void Should_Not_Allow_No_Sense_Ages(int age) {
		// Arrange
		person.setAge(age);
		expected = RegisterResult.INVALID_AGE;
		// Act
		RegisterResult result = registry.registerVoter(person);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	public void Should_Allow_Alive_People(){
		//Arrange
		person.setAlive(true);
		expected = RegisterResult.VALID;
		// Act
		RegisterResult result = registry.registerVoter(person);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void Should_Not_Allow_Dead_People(){
		//Arrange
		person.setAlive(false);
		expected = RegisterResult.DEAD;
		// Act
		RegisterResult result = registry.registerVoter(person);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void Should_Not_Allow_People_Twice(){
		//Arrange
		expected = RegisterResult.DUPLICATED;
		// Act
		RegisterResult result = registry.registerVoter(person);
		RegisterResult result = registry.registerVoter(person);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	// TODO Complete with more test cases
	}
}
