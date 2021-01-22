package com.yardsalebe.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostRepository dao;
	
	@GetMapping("")
	public List<Post> getPosts() {
	    List<Post> foundPosts = dao.findAll();
	    return foundPosts;
	}
	
	@GetMapping("/{ID}")
    public ResponseEntity<Post> getPost(@PathVariable(value="ID") Integer id) {
        Post foundPost = dao.findById(id).orElse(null);

        if(foundPost == null) {
            return ResponseEntity.notFound().header("Message","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundPost);
	}
	
	@PostMapping("")
	public ResponseEntity<Post> postMessage(@RequestBody Post post, @RequestBody User user) {
		post.setUserName(user.getUsername()); 
		post.setTimeStamp(LocalDateTime.now());
		post.setStreetAddress(user.getStreetAddress());
		post.setCity(user.getCity());
		post.setState(user.getState());
		post.setZip(user.getZip());
		Post createdPost = dao.save(post);
	    return ResponseEntity.ok(createdPost);
	}
	
	@PutMapping()
    public ResponseEntity<Post> updatePost(@PathVariable(value="ID") Integer id, @RequestBody Post post) {
		Post foundPost = dao.findById(id).orElse(null);
    	
    	if(foundPost == null) {
    		return ResponseEntity.notFound().header("Message","Nothing found with that id").build();
        }else {
        	Post updatedPost = dao.save(post);
        	return ResponseEntity.ok(updatedPost);
    	}
    }
	
    @DeleteMapping("/{ID}")
    public ResponseEntity<Post> deleteMessage(@PathVariable(value="ID") Integer id) {
        Post foundPost = dao.findById(id).orElse(null);

        if(foundPost == null) {
            return ResponseEntity.notFound().header("Message","Nothing found with that id").build();
        }else {
            dao.delete(foundPost);
        }
        return ResponseEntity.ok().build();
    }
}
