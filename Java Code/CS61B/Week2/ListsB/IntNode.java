public class IntNode{

	private int item;
	private IntNode next;

	public IntNode(int i, IntNode j){
		item = i;
		next = j;
	}

	public int getItem(){
		return item;
	}

	public IntNode getNextNode(){
		return next;
	}

}