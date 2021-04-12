package agilethought.internship.container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;


@EnableAsync //Enables Spring ability to run Asynchronous methods in background thread pool
public class ConfigAsyncExecutor {
	private BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>(5);
	
	@Bean
	public Executor asyncExecutor() {
		int corePoolSize = 3;
		int maximumPoolSize = 4;
		long keepAliveTime = 2;
		TimeUnit timeUnit = TimeUnit.SECONDS;
		ThreadPoolExecutor executor = 
				new ThreadPoolExecutor(
						corePoolSize, 
						maximumPoolSize,
						keepAliveTime, 
						timeUnit, 
						blockingQueue);
		
		return new ConcurrentTaskExecutor(executor);
	}
}
