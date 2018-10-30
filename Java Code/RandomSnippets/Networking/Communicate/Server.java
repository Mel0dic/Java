import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

	public static final int PORT = 9001;

	public static void main(String[] args) throws Exception {
		Server server = new Server();
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				System.out.println("Looper");
				new Thread(new Handler(listener.accept())).start();
			}
		} finally {
			listener.close();
		}
	}

	private static class Handler implements Runnable {

		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;

		private String receive;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				// Create character streams for the socket.
				in = new BufferedReader(new InputStreamReader(
				    socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				out.println("CONNECTED");
				while(true){
					receive = in.readLine();
					if(receive.equals("GET_SCORES")){
						for(int i = 0; i < 10; i++){
							out.println("Score Name");
							out.println("Score Score");
							out.println("Score Position");
						}
					}else if(receive.equals("ADD_SCORE")){
						out.println("ADDING_SCORE");
					}
					System.out.println(receive);
				}
			} catch (IOException e) {
				System.out.println(receive);
			} finally {
				// This client is going down! Finish and close any outstandings
				try {
				    socket.close();
				} catch (IOException e) {
				}
			}
		}

	}

}