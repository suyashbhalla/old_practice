import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExampleFirst {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Callable<String> task=()->{
			return "I am in "+Thread.currentThread().getName();
		};
		
		ExecutorService executorService=Executors.newFixedThreadPool(4);
		Future<String> future=executorService.submit(task);
		
		System.out.println(future.get());
		executorService.shutdown();
	}

}
