package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;

public class Registry {
	private ArrayList<Person> persons = new ArrayList<Person>();
	private RegisterResult ans = new RegisterResult();
	
	public RegisterResult registerVoter(Person p){
		ans = (p.getAge() >= 18)? ans.UNDERAGE : (p.isAlive() == true);
		// TODO Validate person and return real result.
		return RegisterResult.VALID;
	}
}
DEAD, UNDERAGE, INVALID_AGE, VALID, DUPLICATED




