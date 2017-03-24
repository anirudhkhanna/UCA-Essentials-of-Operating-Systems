import java.util.*;
import java.net.*;

class PageFetch implements Runnable {

	private String myWebsite;
	
	PageFetch(String url) {
		this.myWebsite = url;
	}
	
	/* Implement the inherited method run() from Runnable */
	public void run() {
		System.out.println("Running ");
		String content = null;
		
		URLConnection connection = null;
		try {
			connection = new URL(myWebsite).openConnection();
			Scanner scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter("\\Z");
			content = scanner.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("content has src of " + myWebsite); // Print content string for source code
		System.out.println(content);
		System.out.println("\n\n");
	}
}

public class ThreadWebPages {

	public static void main(String[] args) {
		PageFetch obj1 = new PageFetch("http://www.google.com");
		PageFetch obj2 = new PageFetch("http://infolab.stanford.edu/~sergey/resume.html");
		
		Thread t1 = new Thread(obj1, "My Thread1");
		Thread t2 = new Thread(obj2, "My Thread2");
		
		System.out.println("\nStart threads: (run threads simultaneously, no order guarantee) ");
		t1.start();
		t2.start();
		
		// Joining threads to make sure main() moves ahead from here only after threads are complete.
		try {
			t1.join();
			t2.join();
		} catch(Exception e) {e.printStackTrace();}
	}
}