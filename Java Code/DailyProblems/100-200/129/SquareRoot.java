import java.lang.Math;

public class SquareRoot{

	public static void main(String[] args){

		System.out.println(findSquareRoot(99980001));
		System.out.println("------------------------------------------------");
		System.out.println(findSquareRootOther(99980001));
		System.out.println("------------------------------------------------");
		System.out.println(findSquareRootAnother(99980001));

	}

	public static int findSquareRoot(int number){
		int i = 0;
		while(i * i++ <= number){
			if(i * i == number){
				return i;
			}
			System.out.println(i + "");
		}
		return 0;
	}

	public static int findSquareRootOther(int number){
		Double error = 0.00001;
		int min = 0;
		int max = number;
		int guess = (min + max) / 2;
		while(Math.abs(Math.pow(guess, 2) - number) >= error){
			if(Math.pow(guess, 2) >= number){
				max = guess;
			}else{
				min = guess;
			}
			guess = (min + max) / 2;
			System.out.println(guess);
		}
		return guess;
	}

	public static int findSquareRootAnother(int number){
		Double error = 0.00001;
		int guess = 1;

		while(Math.abs(Math.pow(guess, 2) - number) >= error){
			guess = (guess + number / guess) / 2;
			System.out.println(guess);
		}

		return guess;
	}

}