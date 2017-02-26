import java.util.concurrent.Semaphore;

class SenderThread implements Runnable {
	
	Semaphore sema;
	
	public SenderThread(Semaphore s) {
		this.sema = s;
	}
	
	public void run() {
		try {
			sema.acquire();
			
			try {
				Thread.sleep(700);
			} catch(Exception e){}
			System.out.println("Producing new value...");
			
			
			sema.release();
		} catch(Exception e) {}
	}
}

class ReceiverThread implements Runnable {
	
	Semaphore sema;
	
	public ReceiverThread(Semaphore s) {
		this.sema = s;
	}
	
	public void run() {
		try {
			sema.acquire();
			
			System.out.println("Consuming new value...");
			
			sema.release();
		} catch(Exception e) {}
	}
}

public class SemaphoreDemo {

	public static void main(String[] args) {

		Semaphore s = new Semaphore(1);
		SenderThread sender = new SenderThread(s);
		ReceiverThread receiver = new ReceiverThread(s);
		
		System.out.println("STARTING THE THREADS: ");
		
		Thread st = new Thread(sender, "ST");
		Thread rt = new Thread(receiver, "RT");
		
		st.start();
		rt.start();
	}
}
