
import java.util.Scanner;

public class one{

	public static void main(String[] args){
		one mainClass = new one();
	}

	public one(){
		// Exercise5();	
		// Exersise8();
		// Exersise9();
		Exersise10();
	}

	public void Exercise5(){
		System.out.println("There are " + (365 * 24 * 60 * 60) + " seconds in a year.");
	}


	public void Exersise8(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter your first number: ");
		int numbOne = Integer.parseInt(reader.nextLine());

		System.out.print("Enter your second number: ");
		int numbTwo = Integer.parseInt(reader.nextLine());

		System.out.println("The total is " + (numbOne + numbTwo));
	}

	public void Exersise9(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter your first number: ");
		int numbOne = Integer.parseInt(reader.nextLine());

		System.out.print("Enter your second number: ");
		int numbTwo = Integer.parseInt(reader.nextLine());

		System.out.println(numbOne + "/" + numbTwo + " = " + (numbOne/numbTwo));
	}

	public void Exersise10(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter the radius: ");
		int radius = Integer.parseInt(reader.nextLine());

		System.out.println("The circumference is " + (2 * Math.PI * radius));
	}

}