package edu.eci.cvds.tdd.registry;
import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
	private Registry registry = new Registry();
	private RegisterResult expected; 
	
	@Test
	public void Should_Allow_People_With_18() {
		// Arrange
		Person person = new Person("Nick", 1001, 21, Gender.MALE, true);
		person.setAge(18);
		expected = RegisterResult.VALID;
		// Act
		RegisterResult result = registry.registerVoter(person);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void Should_Not_Allow_LessThan_18() {
		// Arrange
		Person person = new Person("Nick", 1002, 21, Gender.MALE, true);
		person.setAge(17);
		expected = RegisterResult.UNDERAGE;
		// Act
		RegisterResult result = registry.registerVoter(person);
		// Assert
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void Should_Not_Allow_No_Sense_Ages() {
		// Arrange
		Person person = new Person("Nick", 1003, 21, Gender.MALE, true);
		person.setAge(-10);
		expected = RegisterResult.INVALID_AGE;
		// Act
		RegisterResult result = registry.registerVoter(person);
		// Assert
		Assert.assertEquals(expected, result);
	}
	@Test
	public void Should_Allow_Alive_People(){
		//Arrange
		Person person = new Person("Nick", 1004, 21, Gender.MALE, true);
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
		Person person = new Person("Nick", 1005, 21, Gender.MALE, true);
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
		Person person = new Person("Nick", 1006, 21, Gender.MALE, true);
		expected = RegisterResult.DUPLICATED;
		// Act
		RegisterResult result = registry.registerVoter(person);
		result = registry.registerVoter(person);
		// Assert
		Assert.assertEquals(expected, result);
	}
}
