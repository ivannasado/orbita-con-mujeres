package com.orbita.orbitaconmujeres.service;

import com.orbita.orbitaconmujeres.model.Post;

public interface PostService {
	
	Post createPost(Post post);
	Post getPostById(Long id);
	Post updatePost(Post post, Long id);
	void deletePost(Long id);

}
