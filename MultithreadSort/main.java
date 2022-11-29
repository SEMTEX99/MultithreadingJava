package MultithreadSort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(new InputReader());
		executorService.shutdown();
		System.out.println("Program Finished");
	}
}