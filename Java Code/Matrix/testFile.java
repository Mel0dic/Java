import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class testFile extends JFrame{
	public static void main(String[] args){

		char something;

		for(int i = 0; i < 96; i++){

			something = (char)(0x30A0 + i);

			System.out.println(something);

			try{
				Thread.sleep(500);
			}catch(Exception exe){}

		}

	}
}