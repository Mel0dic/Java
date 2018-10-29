import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;

public class User{

	public static final int PORT = 9001;

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
		Scanner scanner = new Scanner(System.in);
		System.out.print("Eneter Name: ");
		ip = scanner.nextLine();
		System.out.println(ip);
	}

	public void run() throws IOException{
		Socket socket = new Socket(ip, 9001);

		in = new BufferedReader(new InputStreamReader(
			socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

		while(true){
			String line = in.readLine();
			System.out.println("Line = (" + line + ")");
			out.println("Hello?");
		}
	}

}