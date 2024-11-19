package com.orbita.orbitaconmujeres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orbita.orbitaconmujeres.model.Tag;
import com.orbita.orbitaconmujeres.repository.TagRepository;





@RestController
@RequestMapping("/api/v1/tag")
public class TagController{

    final TagRepository tagRepository;
	


    public TagController (@Autowired TagRepository tagRepository )
    {
        this.tagRepository = tagRepository;
    }

    @GetMapping
    public Iterable<Tag> getTag(){
        return tagRepository.findAll();
    }
}