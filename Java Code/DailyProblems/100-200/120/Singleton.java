/**
 * Implement the singleton pattern with a twist. First, instead of storing one instance, 
 * store two instances. And in every even call of getInstance(), return the first instance 
 * and in every odd call of getInstance(), return the second instance.
 */

public class Singleton{

	private static Singleton singletonInstanceOne = null;
	private static Singleton singletonInstanceTwo = null;
	private static boolean callEvenOdd = false;

	private String name;

	private Singleton(String name){
		this.name = name;
	}

	public static Singleton getInstance(){

		if(singletonInstanceOne == null){
			singletonInstanceOne = new Singleton("One");		
			singletonInstanceTwo = new Singleton("Two");
		}

		return (callEvenOdd = !callEvenOdd)?singletonInstanceOne:singletonInstanceTwo;
	}
	
	public void printName(){
		System.out.println(name);
	}

}