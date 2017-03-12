import java.io.*;
import java.net.Socket;

public class SocketClient {
	
	public static void main(String[] args) {
		
		try {
			
			Socket s = new Socket("localhost", 5555);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Knock Knock!");
			
			dout.flush();
			dout.close();
			s.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
