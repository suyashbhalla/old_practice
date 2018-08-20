import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFirstExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable task = () -> {
			
			System.out.println("i am in " + Thread.currentThread().getName());
		};
//		ExecutorService executor = Executors.newSingleThreadExecutor();
		ExecutorService executor = Executors.newFixedThreadPool(5);
		

		for (int i = 0; i < 10; i++) {
			executor.execute(task);
		}
		executor.shutdown();

	}

}
