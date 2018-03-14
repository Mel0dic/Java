
import java.util.Scanner;

public class one{

	public static void main(String[] args){
		one mainClass = new one();
	}

	public one(){
		// Exercise5();	
		// Exercise8();
		// Exercise9();
		// Exercise10();
		// Exercise11();
		// Exercise12();
		Exercise13();
	}

	public void Exercise5(){
		System.out.println("There are " + (365 * 24 * 60 * 60) + " seconds in a year.");
	}


	public void Exercise8(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter your first number: ");
		int numbOne = Integer.parseInt(reader.nextLine());

		System.out.print("Enter your second number: ");
		int numbTwo = Integer.parseInt(reader.nextLine());

		System.out.println("The total is " + (numbOne + numbTwo));
	}

	public void Exercise9(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter your first number: ");
		int numbOne = Integer.parseInt(reader.nextLine());

		System.out.print("Enter your second number: ");
		int numbTwo = Integer.parseInt(reader.nextLine());

		System.out.println(numbOne + "/" + numbTwo + " = " + (numbOne/numbTwo));
	}

	public void Exercise10(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter the radius: ");
		int radius = Integer.parseInt(reader.nextLine());

		System.out.println("The circumference is " + (2 * Math.PI * radius));
	}

	public void Exercise11(){
		Scanner reader = new Scanner(System.in);
		int[] storedNumArray = new int[2]; 
		for(int i = 0; i < 2; i++){
			System.out.println("Enter you number: ");
			storedNumArray[i] = Integer.parseInt(reader.nextLine());
		}
		if((storedNumArray[0] - storedNumArray[1]) > 0){System.out.println("number 1 is bigger");}
		else{System.out.println("number 2 is bigger");}
	}

	public void Exercise12(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter person 1s name: ");
		String namePerson1 = reader.next();
		System.out.print("Enter person 1s age: ");
		int agePerson1 = Integer.parseInt(reader.next());
		System.out.print("Enter person 2s name: ");
		String namePerson2 = reader.next();
		System.out.print("Enter person 2s age: ");
		int agePerson2 = Integer.parseInt(reader.next());
		System.out.println(String.format("%s and %s are %d years old in total.", namePerson1, namePerson2, (agePerson1 + agePerson2)));
	}

	public void Exercise13(){
		System.out.println("13");
	}

}