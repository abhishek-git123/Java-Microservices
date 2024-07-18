package com.learning.restservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int usersCount=0;
	static {
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Joe", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findParticularUser(int userId){
		/* for(User user : users) {
			if(userId == user.getId()) {
				return user;
			}
		}
		return null; */
		Predicate<User> predicate = user -> user.getId().equals(userId);
		return users.stream().filter(predicate).findFirst().get();
	}
	
	public User saveUser(User user) {
		user.setId(++usersCount);
		users.add(user);
		
		return user;
	}
	
	
}
