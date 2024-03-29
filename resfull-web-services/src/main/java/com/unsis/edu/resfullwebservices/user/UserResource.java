package com.unsis.edu.resfullwebservices.user;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> retrieveAllUser() {
		return service.finAll();
	}

	@GetMapping("/users/{id}")
	//public User retrieveUser(@PathVariable int id) {
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user=service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		
		/*org.springframework.hateoas.Resource<User> resource = new org.springframework.hateoas.Resource<User>(user);
		ControllerLinkBuilder linkTo =linkTo(methodOn(this.getClass()).retrieveAllUser());
		
		resource.add(linkTo.withRel("All-users"));*/
		EntityModel<User> model = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUser());
		model.add(linkTo.withRel("all-users"));
		
		return model;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user=service.deleteByID(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		
	}
	
	

	@PostMapping("/users")
	public ResponseEntity<Object> createUse(@Valid @RequestBody User user) {
		User savedUSer=service.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUSer.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
