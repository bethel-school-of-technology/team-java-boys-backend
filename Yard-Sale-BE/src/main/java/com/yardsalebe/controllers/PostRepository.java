package com.yardsalebe.controllers;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Integer>{
    List<Post> findByUserName(String userName);
    // List<Post> findById(int ID);
}
