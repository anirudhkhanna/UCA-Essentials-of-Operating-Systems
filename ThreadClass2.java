
public class ThreadClass2 implements Runnable {
	
	/* Implement the inherited method run() from Runnable */
	public void run() {
		System.out.println("Running a thread" + Thread.currentThread().getName());
	}

	/* Main */
	public static void main(String[] args) {
		ThreadClass2 dObj = new ThreadClass2();
		
		Thread t = new Thread(dObj, "tName"); // allocate a Thread object by passing a Runnable object and a thread name
		t.start();	// start() the Thread object, which basically calls its run() method after creating a new thread of execution
	}
}
