package com.orbita.orbitaconmujeres.serviceimpl;


import java.util.Optional;
import com.orbita.orbitaconmujeres.model.Post;
import com.orbita.orbitaconmujeres.repository.PostRepository;
import com.orbita.orbitaconmujeres.service.PostService;

public class PostServiceImpl implements PostService{

	PostRepository postRepository;
	
	@Override
	public Post createPost(Post post) {
		// TODO Verificar si los atributos son válidos
		Post.setActive(true); 
		post.setIdPost(null); 
		Post newBoard = postRepository.save( post );
		return newBoard;
	}

	@Override
	public Post getPostById(Long id) {
		Optional<Post> optionalPost = postRepository.findById(id);
		if( optionalPost.isEmpty()) {
			throw new IllegalStateException("Post does not exist with id " + id);
		}
		Post existingPost = optionalPost.get();
		return existingPost;
	}


	@Override
	public Post updatePost(Post post, Long id) {
		// TODO Auto-generated method stub
		Post existingPost = getPostById(id);
		existingPost.setIdPost( post.getIdPost() );
			
		return postRepository.save(existingPost);
	}

	@Override
	public void deletePost(Long id) {
		Post existingPost = getPostById(id);
		Post.setActive(false); // desactivar al usuario
		postRepository.save(existingPost);
	}
}
