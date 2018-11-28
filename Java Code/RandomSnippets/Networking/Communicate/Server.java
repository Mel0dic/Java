import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

	public static final int PORT = 9001;

	public static void main(String[] args) throws Exception {
		// Create a new server socket with the PORT to open
		ServerSocket listener = new ServerSocket(PORT);
		try {
			// Create infinite loop to accept new connections and print when the device connected
			while (true) {
				System.out.println("New Device Connected");
				new Thread(new Handler(listener.accept())).start();
			}
		} 
		// Make sure to close the listener when the program is closing
		finally {
			listener.close();
		}
	}

	// Create a Handler class that implements a runnable so each user can run on its own thread
	// and multiple connections at the same time do not clog the system
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
				// Tell the connecting device that a stream has been successfully created
				out.println("CONNECTED");
				// While true (while the device is connected)
				while(true){
					// Take an input from the input stream
					receive = in.readLine();
					// If the input is not null and the input is the command GET_SCORES
					if(reveive != null && receive.equals("GET_SCORES")){
						// Return a temporary set of data
						for(int i = 0; i < 10; i++){
							out.println("Name" + Integer.toString(i));
							out.println(Integer.toString(i * 10 + 10));
							out.println(Integer.toString(i + 1));
						}
					}
					// If the input is not null and the input is the command ADD_SCORE
					else if(reveive != null && receive.equals("ADD_SCORE")){
						// Temporary outpu
						out.println("ADDING_SCORE");
					}
					// Print out the command into the 
					System.out.println(receive);
				}
			} catch (IOException e) {
				// If there is an error print the current received command
				System.out.println(receive);
			} finally {
				// This client is going down! Finish and close any outstandings
				try {
					in.close();
					out.close();
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
		}

	}

}