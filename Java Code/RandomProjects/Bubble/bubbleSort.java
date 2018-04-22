public class bubbleSort{

	public static int[] listToSearch = new int[150];

	public static void main(String[] args){
		for(int i = 0; i < 150; i++){
			listToSearch[i] = (i+1);
		}
		new bubbleSort().sort(listToSearch, 17);
	}

	public void sort(int[] sortList, int valueToFind){
		int startOfList = 0;
		int endOfList = sortList.length;
		int middleValue = (int) endOfList / 2;

		int count = 0;

		while((endOfList - startOfList) > 0 && sortList[middleValue] != valueToFind){
			if(sortList[middleValue] < valueToFind){
				startOfList = middleValue;
				middleValue = middleValue + (endOfList - middleValue) / 2;
			}else if(sortList[middleValue] > valueToFind){
				endOfList = middleValue;
				middleValue = (int) endOfList / 2;
			}
			count++;
		}
		System.out.println(sortList[middleValue]);
		System.out.println(count);
	}

}