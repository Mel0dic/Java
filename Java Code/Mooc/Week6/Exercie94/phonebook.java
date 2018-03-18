import java.util.List;
import java.util.ArrayList;

public class phonebook{

	List<Person> phonebookList = new ArrayList<Person>();

	public static void main(String[] args){
		phonebook phonebook = new phonebook();
		phonebook.add("Pekka Mikkola", "040-123123");
		phonebook.add("Edsger Dijkstra", "045-456123");
		phonebook.add("Donald Knuth", "050-222333");

		String number = phonebook.searchNumber("Pekka Mikkola");
		System.out.println(number);

		number = phonebook.searchNumber("Martti Tienari");
		System.out.println(number);
	}

	public void add(String nameOfPersonToAdd, String phoneNumberOfPersonToAdd){
		Person personToAdd = new Person(nameOfPersonToAdd, phoneNumberOfPersonToAdd);
		phonebookList.add(personToAdd);
	}

	public void printAll(){
		for(Person i : phonebookList){
			System.out.println(i);
		}
	}

	public String searchNumber(String personsNumberNeeded){
		for(Person i : phonebookList){
			if(personsNumberNeeded.equals(i.getName())){
				return (i.getPhoneNumber());
			}
		}
		return("Not Found");
	}

}