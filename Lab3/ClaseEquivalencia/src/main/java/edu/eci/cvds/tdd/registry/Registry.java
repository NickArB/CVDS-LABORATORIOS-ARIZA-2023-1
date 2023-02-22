package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;

public class Registry {
	private ArrayList<Person> persons = new ArrayList<Person>();
	private RegisterResult ans = new RegisterResult();
	
	public static RegisterResult registerVoter(Person p){
		
		ans = validateAge(p);
		return (ans != RegisterResult.VALID) ? ans : (p.isAlive()) ? RegisterResult.DEAD : (validateIsDuplicated(p)) ? RegisterResult.DUPLICATED :  RegisterResult.VALID;
	}
	
	private static RegisterResult validateAge(Person p){
		int age = p.getAge();
		return (age < 18 && age >= 0) ? RegisterResult.UNDERAGE : (age > 160 || age < 0) ? RegisterResult.INVALID_AGE : RegisterResult.VALID;
	}
	
	private static boolean validateIsDuplicated(Person p){
		boolean duplicated = false;
		for (int i = 0; i < persons.size(); i++){
			if (persons.get(i).getId() == p.getId()){
				duplicated = true;
				break;
			}
		}
		return duplicated;
	}
}
