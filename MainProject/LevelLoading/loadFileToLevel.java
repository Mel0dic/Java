import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class loadFileToLevel{

	public static void main(String[] args){
		loadFileToLevel main = new loadFileToLevel();
		try{
			main.openFile();
		}catch(IOException e){
			System.out.println(e);
		}
	}

	public void openFile() throws IOException{
		//Get file location and create instance of the file "converts given pathname string into an abstract pathname"
		File file = new File("level.txt");
		//Create BufferedReader with FileReader
		BufferedReader br = new BufferedReader(new FileReader(file));
		//Initialize empty string
		String line = null;

		//While the br.readLine() does not return null
		while( (line = br.readLine())!= null ){
			System.out.println(line);
		}
	}

}