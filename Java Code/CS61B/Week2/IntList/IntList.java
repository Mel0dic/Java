public class IntList{

	public static void main(String[] args){
		IntList intListOne = new IntList(1, null);
		intListOne.add(5);
		intListOne.add(10);
		intListOne.add(45);

		System.out.println(intListOne.size());
		System.out.println(intListOne.get(2));

		IntList intListIncreased = incrList(intListOne, 5);
		System.out.println(intListOne.get(3));
		System.out.println(intListIncreased.get(3));
	}

	private int first;
	private IntList rest;

	public IntList(int numberToStore, IntList integerList){
		first = numberToStore;
		rest = integerList;
	}

	/**
	 * Return The Size Of The List
	 * @return integer size of the list
	 */
	public int size(){
		if(rest == null){
			return 1;
		}else{
			return rest.size() + 1;
		}
	}

	/**
	 * Add A Number Onto The List
	 * @param number the number to add onto the list
	 */
	public void add(int number){
		if(rest != null){
			rest.add(number);
		}else{
			rest = new IntList(number, null);
		}
	}


	/**
	 * Get the number at given position
	 * @param numberToGet position to get number from
	 */
	public int get(int numberToGet) throws ArrayIndexOutOfBoundsException{
		//If the number is 0 return number else if rest is null throw exception else carry on
		if(numberToGet == 0){
			return first;
		}else if(rest == null){
			throw new ArrayIndexOutOfBoundsException();
		}else{
			return rest.get(numberToGet - 1);
		}
	}

	/**
	 * Returns an IntList identical to L, but with all values incremented by X
	 */
	public static IntList incrList(IntList listToIncrease, int x){
		IntList newList = new IntList(listToIncrease.get(0) + x, null);

		for(int i = 1; i < listToIncrease.size(); i++){
			newList.add(listToIncrease.get(i) + x);
		}

		return newList;
	}

	/**
	 * Returns an IntList identical to L, but with all values incremented by X
	 * Cannot use 'new' keyword
	 */
	public static IntList dcrList(IntList listToDecrease, int x){

	}

}