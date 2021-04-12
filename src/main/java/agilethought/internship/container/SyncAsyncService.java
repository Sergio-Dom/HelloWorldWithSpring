package agilethought.internship.container;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SyncAsyncService {
	@Async
	public CompletableFuture<UserModel> getUserAsync(String userId) throws InterruptedException {
		RestTemplate restTemplate = new RestTemplate();
		UserModel user = restTemplate.getForObject("http://localhost:8080/api/v1/users/" + userId, UserModel.class);
		Thread.sleep(5000);

		return CompletableFuture.completedFuture(user);
	}
	
	public UserModel getUserSync(String userId) throws InterruptedException{
		RestTemplate restTemplate = new RestTemplate();
		UserModel user = restTemplate.getForObject("http://localhost:8080/api/v1/users/" + userId, UserModel.class);
		Thread.sleep(5000);
		return user;
	}
}
