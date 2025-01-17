package com.saitejaswar.blogapp.repositories;

import com.saitejaswar.blogapp.domain.entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends CrudRepository<Post, UUID> {
}
