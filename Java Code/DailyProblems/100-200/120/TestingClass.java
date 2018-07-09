public class TestingClass{

	public static void main(String[] args){
		Singleton.getInstance().printName();
		Singleton.getInstance().printName();
		Singleton.getInstance().printName();
		Singleton.getInstance().printName();

		//NOT ALLOWED
		// Singleton single = new Singleton("Hello");
		// single.printName();
	}

}