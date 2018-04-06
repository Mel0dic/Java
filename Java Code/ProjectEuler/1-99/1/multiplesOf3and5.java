public class multiplesOf3and5{

	public static void main(String[] args){
		new multiplesOf3and5();
	}


	public multiplesOf3and5(){
		int totalCount = 0;
		for(int i = 0; i < 1000; i++){
			if(i % 3 == 0 || i % 5 == 0){
				totalCount += i;
			}
		}
		System.out.println(totalCount);
	}

}