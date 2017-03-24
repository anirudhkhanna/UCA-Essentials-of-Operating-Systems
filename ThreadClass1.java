
class Dummy implements Runnable {

	String threadName;
	
	public Dummy(String name) {
		threadName = name;
	}
	
	/* Implement the inherited method run() from Runnable */
	public void run() {
		System.out.println("Running " + threadName);
		try {Thread.sleep(1000);} catch(InterruptedException e) {e.printStackTrace();}
		System.out.println("Finished " + threadName);
	}
}

public class ThreadClass1 {
	public static void main(String[] args) {
		Dummy dObj = new Dummy("Dummy Thread");
		
		Thread t = new Thread(dObj, "My DT");	// allocate a Thread object by passing a Runnable object and a thread name
		t.start();	// start() the Thread object, which basically calls its run() method after creating a new thread of execution
	}
}
