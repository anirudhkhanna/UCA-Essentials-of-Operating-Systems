import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class SocketServer {
	
	public static void main(String[] args) {
		
		try {
			
			ServerSocket ss = new ServerSocket(5555);
			
			while(true) {
				Socket s = ss.accept();
				DataInputStream din = new DataInputStream(s.getInputStream());
				String str = (String)din.readUTF();
				System.out.println("Message = " + str);
			}
			
		//	ss.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
