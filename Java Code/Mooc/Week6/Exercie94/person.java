public class Person{

	public String phoneNumber;
	public String name;

	public Person(String nameOfPerson, String numberOfPhone){
		name = nameOfPerson;
		phoneNumber = numberOfPhone;
	}

	public void setPhoneNumber(String number){
		phoneNumber = number;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setName(String nameOfPerson){
		name = nameOfPerson;
	}

	public String getName(){
		return name;
	}

	public String toString() {
		return String.format("%s Number: %s", this.name, this.phoneNumber);
	}

}