package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;

public class Registry {
	private ArrayList<Person> persons = new ArrayList<Person>();
	
	public RegisterResult registerVoter(Person p){
		RegisterResult ans = validateAge(p);
		return (ans != RegisterResult.valueOf("VALID")) ? ans : 
				(!p.isAlive()) ? RegisterResult.valueOf("DEAD") : 
				(validateIsDuplicated(p)) ? RegisterResult.valueOf("DUPLICATED") :  
				RegisterResult.valueOf("VALID");
	}
	
	private RegisterResult validateAge(Person p){
		int age = p.getAge();
		return (age < 18 && age >= 0) ? RegisterResult.valueOf("UNDERAGE") : 
				(age > 160 || age < 0) ? RegisterResult.valueOf("INVALID_AGE") : 
				RegisterResult.valueOf("VALID");
	}
	
	private boolean validateIsDuplicated(Person p){
		boolean duplicated = false;
		for (int i = 0; i < persons.size(); i++){
			if (persons.get(i).getId() == p.getId()){
				duplicated = true;
				break;
			}
		}
		addPerson(p, duplicated);
		return duplicated;
	}
	
	private void addPerson(Person p, boolean isDuplicated){
		if (!isDuplicated){
			persons.add(p);
		}
	}
}
