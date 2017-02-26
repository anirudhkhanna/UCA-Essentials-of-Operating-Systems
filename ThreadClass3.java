
public class ThreadClass3 {
	public static void main(String[] args) {
		Dummy d1 = new Dummy("Thread 1");
		Dummy d2 = new Dummy("Thread 2");
		Thread t1 = new Thread(d1, "My DT");
		Thread t2 = new Thread(d2, "My DT");
		
		t1.start();

		/* For t2 to start only after t1 */
		try{
			t1.join();	// join t1
		} catch(Exception e) {e.printStackTrace();}
		
		t2.start();
	}
}
