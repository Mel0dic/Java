import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;

public class User{

	public static final int PORT = 9001;

	private Scanner scanner;

	private BufferedReader in;
	private PrintWriter out;
	private String ip;

	public static void main(String[] args){
		User user = new User();
		try{
			user.run();
		}catch(IOException except){
			System.out.println(except);
		}
	}

	public User(){
		scanner = new Scanner(System.in);
		System.out.print("Eneter Name: ");
		ip = scanner.nextLine();
		System.out.println(ip);
	}

	public void run() throws IOException{
		Socket socket = new Socket(ip, 9001);

		in = new BufferedReader(new InputStreamReader(
			socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

		String line = in.readLine();
		System.out.println("Start Input = " + line);

		while(true){
			System.out.print("Print Your Command : ");
			String command = scanner.nextLine();
			System.out.println("Sending Command");
			out.println(command);
			System.out.println("Command Sent");
			if(command.equals("GET_SCORES")){
				String[][] arrayOfStuff = new String[10][3];
				for(int i = 0; i < 10; i++){
					for(int x = 0; x < 3; x++){
						String input = in.readLine();
						arrayOfStuff[i][x] = input;
						System.out.println(input);
					}
				}
				for(String[] arr : arrayOfStuff){
					for(String outLine : arr){
						System.out.println(outLine);
					}
				}
			}else if(command.equals("ADD_SCORE")){
				String inputLine = in.readLine();
				System.out.println(inputLine);
			}
			System.out.println("Read Line");
		}
	}

}