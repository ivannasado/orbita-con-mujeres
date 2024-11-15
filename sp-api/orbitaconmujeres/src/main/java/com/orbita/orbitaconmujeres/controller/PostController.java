package com.orbita.orbitaconmujeres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orbita.orbitaconmujeres.model.Post;
import com.orbita.orbitaconmujeres.repository.PostRepository;



@RestController
@RequestMapping("/post")
public class PostController {


	    final PostRepository postRepository;
		


	    public PostController (@Autowired PostRepository postRepository )
	    {
	        this.postRepository = postRepository;
	    }

	    @GetMapping
	    public Iterable<Post> getPost(){
	        return postRepository.findAll();
	    }
	}