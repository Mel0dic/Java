import java.util.*;
import java.io.IOException;

public class matrix01{
	public static void main(String[] args){
		System.out.println("TestPrint");
		//Linux Only
		//System.out.print("\033[H\033[2J");
		clearConsole();
		System.out.flush();
	}

	public final static void clearConsole(){
		final String osQuery = System.getProperty("os.name");

		try{
			if(osQuery.contains("Windows")){
				Runtime.getRuntime().exec("cmd");
			}
			else{
				Runtime.getRuntime().exec("clear");
			}
		}catch(){
			//
		}
	}
}
