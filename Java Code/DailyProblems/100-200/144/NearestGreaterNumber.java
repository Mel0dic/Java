public class NearestGreaterNumber{

	public static void main(String[] args){
		int[] arr = {4, 1, 3, 5, 6};
		System.out.println(nearestGreaterNumber(arr, 0) + "");
	}

	public static int nearestGreaterNumber(int[] usedArray, int index){
		int arraySize = usedArray.length;
		int i = index, j = index, count = 0;
		while(i < arraySize || j >= 0 || count > (arraySize / 2)){
			if(usedArray[i] > usedArray[index] || usedArray[j] > usedArray[index]){
				return count;
			}
			if(!(i == arraySize-1)){
				i++;
			}else if(!(j == 0)){
				j--;
			}
			count++;
		}
		return null;
	}

}