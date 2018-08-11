/**
 * An SLList is a list of integers, which hides the nakedness of the IntNode Class
 */
public class SLList{

	public IntNode first;

	private class IntNode{
	
		public int item;
		public IntNode next;
	
		public IntNode(int i, IntNode j){
			item = i;
			next = j;
		}
	
	}

	public SLList(int x){
		first = new IntNode(x, null);
	}

	public static void main(String[] args){
		//Create an intlist with one node
		SLList L = new SLList(10);
		System.out.println(L.first);
	}

	public int get(int numberToGet){
		if(numberToGet == 0){
			return first.getItem();
		}else if(first.getNextNode() != null){
			return get(numberToGet - 1, node.getNextNode());
		}
	}

	public int get(int numberToGet, IntNode node){
		if(numberToGet == 0){
			return node.getItem();
		}else if(node.getNextNode() != null){
			return get(numberToGet - 1, node.getNextNode());
		}
	}

	public void add(int numberToAdd){

	}

}