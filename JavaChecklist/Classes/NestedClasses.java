public class NestedClasses{

	private int varInClass;

	public static void main(String[] args){
		new NestedClasses();
	}

	public NestedClasses(){
		varInClass = 10;
		InsideClass inside = new InsideClass();
		//Cannot access any variables in the nested class unless public
		System.out.println(varInInsideClass);
		System.out.println(publicVarInInsideClass);
	}

	public class InsideClass{

		private int varInInsideClass;
		public int publicVarInInsideClass;

		public InsideClass(){
			varInInsideClass = 20;
			publicVarInInsideClass = 30;
			//Can access private variables in parent class
			System.out.println(varInClass);
		}

	}


}

/*

Nested classes are divided into two categories: static and non-static. Nested classes that are declared static are called static nested classes. Non-static nested classes are called inner classes

*/