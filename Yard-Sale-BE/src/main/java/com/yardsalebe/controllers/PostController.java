package com.yardsalebe.controllers;

import java.security.Principal;
// import java.time.LocalDateTime;
import java.util.ArrayList;
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

	@Autowired
	UserRepository userRepo;
	
	@GetMapping()
	public List<Post> getPost() {
		return dao.findAll();
	}

	@GetMapping("/posts") 
	public ResponseEntity<List<Post>> getPostByUser(Principal myPrincipal ) {
		
		List<Post> foundPosts = dao.findAll();

		List<Post> searchPost = new ArrayList<Post>();
		String currentUser = myPrincipal.getName();
		for (Post post : foundPosts){
			post.toString();
			// System.out.println(post.getState());
			if (post.getuserName().equals(currentUser)){
				searchPost.add(post);
				// System.out.println("found post with the state");
			}
		}
        return ResponseEntity.ok(searchPost);
	}

	@GetMapping("/search/state/{state}") 
	public ResponseEntity<List<Post>> getPostByState(@PathVariable String state) {
		
		List<Post> foundPosts = dao.findAll();
// System.out.println(state);
		List<Post> searchPost = new ArrayList<Post>();
		
		for (Post post : foundPosts){
			post.toString();
			// System.out.println(post.getState());
			if (post.getState().equals(state)){
				searchPost.add(post);
				// System.out.println("found post with the state");
			}
		}
        return ResponseEntity.ok(searchPost);
	}

// 	@GetMapping("/search/city/{city}") 
// 	public ResponseEntity<List<Post>> getPostByState(@PathVariable String city) {
		
// 		List<Post> foundPosts = dao.findAll();
// System.out.println(city);
// 		List<Post> searchPost = new ArrayList<Post>();
		
// 		for (Post post : foundPosts){
// 			post.toString();
// 			System.out.println(post.getState());
// 			if (post.getState().equals(state)){
// 				searchPost.add(post);
// 				System.out.println("found post with the state");
// 			}
// 		}
//         return ResponseEntity.ok(searchPost);
	// }

	// @GetMapping("/serach/city/{cityName}")
	// public ResponseEntity<Post> getPostByCity(@PathVariable(value="city") String city) {
    //     Post foundPost = dao.findAll(city).orElse(null);

    //     if(foundPost == null) {
    //         return ResponseEntity.notFound().header("Message","Nothing found with that city name").build();
    //     }
    //     return ResponseEntity.ok(foundPost);
	// }
		
	@PostMapping("")
	public ResponseEntity<Post> postMessage(@RequestBody Post post, Principal myPrincipal) {
		post.setuserName(myPrincipal.getName());
		Post createdPost = dao.save(post);
	    return ResponseEntity.ok(createdPost);
	}

	@GetMapping("/{ID}")
    public ResponseEntity<Post> getPost(@PathVariable(value="ID") Integer ID) {
        Post foundPost = dao.findById(ID).orElse(null);

        if(foundPost == null) {
            return ResponseEntity.notFound().header("Message","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundPost);
	}

	
	@PutMapping("/{ID}")
    public ResponseEntity<Post> updatePost(@PathVariable(value="ID") Integer id, @RequestBody Post post) {
		Post foundPost = dao.findById(id).orElse(null);    	
    	if(foundPost == null) {
    		return ResponseEntity.notFound().header("Message","Nothing found with that id").build();
        }else {
			// System.out.println(post.getStreetAddress());
			// System.out.println(post.getCity());
			// if(post.getStreetAddress() != null && post.getStreetAddress().length() != 0 ) {
			// System.out.println("Reached found address post");
			// 	foundPost.setStreetAddress(post.getStreetAddress());
			// }
			// if(post.getCity() != null && post.getCity().length() != 0) {
			// 	foundPost.setCity(post.getCity());
			// }
			// if(post.getState() != null && post.getState().length() != 0 ) {
			// 	foundPost.setState(post.getState());
			// }
			// if(post.getZip() != null && post.getZip().length() != 0 ) {
			// 	foundPost.setZip(post.getZip());
			// }
			if(post.getStartDate() != null && post.getStartDate().length() != 0 ) {
				foundPost.setStartDate(post.getStartDate());
			}
			if(post.getEndDate() != null && post.getEndDate().length() != 0 ) {
				foundPost.setEndDate(post.getEndDate());
			}
			if(post.getStartTime() != null && post.getStartTime().length() != 0 ) {
				foundPost.setStartTime(post.getStartTime());
			}
			if(post.getEndTime() != null && post.getEndTime().length() != 0 ) {
				foundPost.setEndTime(post.getEndTime());
			}
			if(post.getCategories() != null && post.getCategories().length() != 0 ) {
				foundPost.setCategories(post.getCategories());
			}
        	Post updatedPost = dao.save(foundPost);
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
