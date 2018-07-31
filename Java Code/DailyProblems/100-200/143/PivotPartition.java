public class PivotPartition{

	public static void main(String[] args){
		int[] arr = {9, 12, 3, 5, 14, 10, 10};
		printArray(rePartition(arr, 10));
	}

	public static int[] rePartition(int[] first, int pivot){
		int countNum = 0;
		int[] partition = new int[first.length]; 
		for(int i = 0; i < first.length; i++){
			if(first[i] < pivot){
				partition[countNum] = first[i];
				countNum++;
			}
		}
		for(int i = 0; i < first.length; i++){
			if(first[i] == pivot){
				partition[countNum] = first[i];
				countNum++;
			}
		}
		for(int i = 0; i < first.length; i++){
			if(first[i] > pivot){
				partition[countNum] = first[i];
				countNum++;
			}
		}
		return partition;	
	}

	public static void printArray(int[] arrayToPrint){
		String printString = "[";
		for(int i = 0; i < arrayToPrint.length; i++){
			if(i == arrayToPrint.length - 1){
				printString += arrayToPrint[i] + "";
			}else{
				printString += arrayToPrint[i] + ", ";
			}
		}
		printString += "]";
		System.out.println(printString);
	}

}