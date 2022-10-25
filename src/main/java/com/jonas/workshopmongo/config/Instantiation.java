package com.jonas.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jonas.workshopmongo.domain.Post;
import com.jonas.workshopmongo.domain.User;
import com.jonas.workshopmongo.repository.PostRepository;
import com.jonas.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	 private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou Viajar para São Paulo, abraços!",maria);
		Post post2 = new Post(null, sdf.parse("23/03/2020"), "bom dia", "Acordei feliz hoje",maria);
		
	   userReposiroty.saveAll(Arrays.asList(maria, alex, bob));	
	   postRepository.saveAll(Arrays.asList(post1,post2));
	}

}
