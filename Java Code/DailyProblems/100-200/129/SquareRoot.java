public class SquareRoot{

	public static void main(String[] args){

		System.out.println(findSquareRoot(99980001));

	}

	public static int findSquareRoot(int number){
		int i = 0;
		while(i * i++ <= number){
			if(i * i == number){
				return i;
			}
		}
		return 0;
	}

	public static int findSquareRootOther(int number){
		return 0;
	}

}