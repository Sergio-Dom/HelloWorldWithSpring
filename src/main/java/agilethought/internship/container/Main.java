package agilethought.internship.container;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		//SpringApplication.run(Main.class, args);
//		System.out.println("Hop");
//		CompletableFuture<String> future = CompletableFuture.completedFuture("TEST");
//		try {
//			System.out.println("Immediate future completed: " + future.get());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		CompletableFuture<String> future2 = new CompletableFuture<String>();
		
		try {
//			System.out.println("Is future2 completed?: " + future2.get());
			future2.complete("finished");
			System.out.println("Is future2 completed?: " + future2.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
