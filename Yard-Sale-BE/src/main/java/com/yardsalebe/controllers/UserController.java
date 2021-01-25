package com.yardsalebe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private MySQLUserDetailsService userService;
  
  @Autowired
  UserRepository dao;

  @PostMapping("/register")
  public void register(@RequestBody User newUser) {
    userService.Save(newUser);
  }
  
  @GetMapping("")
	public List<User> getUsers() {
	    List<User> foundUsers = dao.findAll();
	    return foundUsers;
	}
}