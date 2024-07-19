package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
@Service
public class UserServiceImpl implements UserService{
	private List<User> users;
	
	public UserServiceImpl() {
		this.users = new ArrayList<>();
		users.add(new User(1L,"mariano","fuente"));
		users.add(new User(2L, "Ana", "Gomez"));
        users.add(new User(3L, "Carlos", "Perez"));
        users.add(new User(4L, "Lucia", "Mendez"));
        users.add(new User(5L, "Pedro", "Rodriguez"));
        users.add(new User(6L, "Sofia", "Lopez"));
        users.add(new User(7L, "Javier", "Martinez"));
        users.add(new User(8L, "Laura", "Garcia"));
        users.add(new User(9L, "Andres", "Sanchez"));
        users.add(new User(10L, "Paula", "Diaz"));
        users.add(new User(11L, "Miguel", "Morales"));
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public Optional<User> finById(Long id) {
		Optional<User> user = null;
//		for(User u : users) {
//			if(u.getId().equals(id)) {
//				user = u;
//				System.out.println("el rol del usuario es : " + u.getRoleName() );
//				break;
//			}
//		}
		
		user = users.stream().filter(usr-> usr.getId().equals(id)).findFirst();
		
		return user ;
	}

}
