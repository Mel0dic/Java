//https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html

//An anonymous class allows you to declare and instantiate a classe at the same time 

public class AnonymousClasses{

	interface Greet{

		public void greet();
		public void greetSomeone(String name);

	}

	public void Hello(){

		//Declare a class inside of the function then instantiate later
		class englishGreeting implements Greet{

			public void greet(){
				System.out.println("Hello");
			}

			public void greetSomeone(String name){
				System.out.println(String.format("Hello, %s", name));
			}

		}

		Greet greetEnglish = new englishGreeting();

		//Declare and instantiate at the same time
		Greet greetFrench = new Greet(){
			String name = "tout le monde";
			public void greet() {
				greetSomeone("tout le monde");
			}
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Salut " + name);
			}
		};

		Greet greetSpanish = new Greet(){
			String name = "mundo";
			public void greet() {
				greetSomeone("mundo");
			}
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hola, " + name);
			}
		};
		greetEnglish.greet();
		greetFrench.greetSomeone("Fred");
		greetSpanish.greet();
	
	}

	public static void main(String[] args){
		AnonymousClasses anonymousClasses = new AnonymousClasses();

		anonymousClasses.Hello();
	}

}