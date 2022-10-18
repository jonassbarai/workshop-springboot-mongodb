package com.jonas.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import javax.xml.crypto.dsig.XMLObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonas.workshopmongo.domain.User;
import com.jonas.workshopmongo.dto.UserDTO;
import com.jonas.workshopmongo.repository.UserRepository;
import com.jonas.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findall() {
		return repo.findAll();
	}

	public User findById(String id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("usuário não encontrado"));			
		
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
		
	}
}
