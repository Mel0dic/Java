import java.util.*;

public class Stream{

	Symbol[] symbolArray = new Symbol[];
	int totalSymbols = random.randint(3, 10);
	int speed = 1;

	public void generateSymbols(){
		for(int i = 0; i < totalSymbols){
			Symbol singleSymbol = new Symbol();
			symbolArray.add(singleSymbol);
		}
	}

	public void render(){
		for(Symbol eachSymbol : symbolArray){
			
		}
	}

}