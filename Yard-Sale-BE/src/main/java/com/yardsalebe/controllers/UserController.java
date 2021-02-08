package com.yardsalebe.controllers;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yardsalebe.auth.MySQLUserDetailsService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
	UserRepository dao;

  @Autowired
  private MySQLUserDetailsService userService;

  @PostMapping("/register")
  public void register(@RequestBody User newUser) {
    userService.Save(newUser);
  }
  
  @GetMapping("")
  public List<User> getUsers() {
	  List<User> foundUsers = dao.findAll();
	  return foundUsers;
  }
  
  @GetMapping("/profile")
  public User getProfile(Principal myPrincipal ) {
	  User foundProfile = dao.findByUsername(myPrincipal.getName());
	  return foundProfile;
  }

  @PutMapping("/update")
  public ResponseEntity<User> updateUser(Principal myPrincipal, @RequestBody User user) {
    User foundUser = dao.findByUsername(myPrincipal.getName());   
    if(foundUser == null) {
      return ResponseEntity.notFound().header("Message","Nothing found with that username").build();
      }else {
        if(user.getFirstName().length() != 0 ) {
          foundUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName().length() != 0 ) {
          foundUser.setLastName(user.getLastName());
        }
        if(user.getStreetAddress().length() != 0 ) {
          foundUser.setStreetAddress(user.getStreetAddress());
        }
        if(user.getCity().length() != 0 ) {
          foundUser.setCity(user.getCity());
        }
        if(user.getState().length() != 0 ) {
          foundUser.setState(user.getState());
        }
        if(user.getZip().length() != 0 ) {
          foundUser.setZip(user.getZip());
        }
        if(user.getEmail().length() != 0 ) {
          foundUser.setEmail(user.getEmail());
        }
        User updatedUser = dao.save(foundUser);
        return ResponseEntity.ok(updatedUser);
    }
}
}