package com.jonas.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonas.workshopmongo.domain.Post;
import com.jonas.workshopmongo.repository.PostRepository;
import com.jonas.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));	
	}
	
}
