package agilethought.internship.container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;

@SpringBootApplication
public class Main implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args).close();
	}

	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		SyncAsyncService syncAsyncService1 = new SyncAsyncService();
		SyncAsyncService syncAsyncService2 = new SyncAsyncService();
		SyncAsyncService syncAsyncService3 = new SyncAsyncService();
		
		/*Uncomment the below lines if you want to use the Sync version*/
//		UserModel user1 = syncAsyncService1.getUserSync("605117aee716032dd932f3c6");
//		UserModel user2 = syncAsyncService2.getUserSync("60515a260b031d1e72e6d3cd");
//		UserModel user3 = syncAsyncService3.getUserSync("60525e2e4fa6f8632849cb91");
		/*Comment the above lines if you want to use the Sync version*/
		
		
		/*Uncomment the below lines if you want to use the Async version*/
		CompletableFuture<UserModel> userPromise1 = syncAsyncService1.getUserAsync("605117aee716032dd932f3c6");
		CompletableFuture<UserModel> userPromise2 = syncAsyncService2.getUserAsync("60515a260b031d1e72e6d3cd");
		CompletableFuture<UserModel> userPromise3 = syncAsyncService3.getUserAsync("60525e2e4fa6f8632849cb91");
		/*Uncomment the above lines if you want to use the Async version*/
		
		/*Uncomment the below line if you want to use the Async version*/
		CompletableFuture.allOf(userPromise1, userPromise2, userPromise3).join();
		/*Uncomment the above line if you want to use the Async version*/
		
		/*Uncomment the below lines if you want to use the Async version*/
		System.out.println("User1: " + userPromise1.get().getFirstName());
		System.out.println("User2: " + userPromise2.get().getFirstName());
		System.out.println("User3: " + userPromise3.get().getFirstName());
		/*Uncomment the above lines if you want to use the Async version*/
		
		//*Uncomment the below lines if you want to use the Sync version*/
//		System.out.println("User1: " + user1.getFirstName());
//		System.out.println("User2: " + user2.getFirstName());
//		System.out.println("User3: " + user3.getFirstName());
		/*Comment the above lines if you want to use the Sync version*/
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		//Completion time in millisecs
		//Sync 15364
		//Async 15373
		System.out.println("More tasks....");
	}

}
