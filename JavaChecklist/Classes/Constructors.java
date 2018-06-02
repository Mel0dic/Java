public class Constructors{


	public static void main(String[] args){
		example exOne = new example();
		exOne.printVars();
		example exTwo = new example(10);
		exTwo.printVars();
		example exThree = new example(10, 20);
		exThree.printVars();
		example exFour = new example(10, 20, 30);
		exFour.printVars();
	}


}

/*Hava multiple constructors for different arguments */

class example{

	private int varOne;
	private int varTwo;
	private int varThree;

	public example(){
		varOne = 1;
		varTwo = 2;
		varThree = 3;
	}

	public example(int uno){
		varOne = uno;
		varTwo = 2;
		varThree = 3;
	}

	public example(int uno, int dos){
		varOne = uno;
		varTwo = dos;
		varThree = 3;
	}

	public example(int uno, int dos, int tres){
		varOne = uno;
		varTwo = dos;
		varThree = tres;
	}

	public void printVars(){
		System.out.println(String.format("Var One = %d, Var Two = %d, Var Three = %d", varOne, varTwo, varThree));
	}

}