package com.omar.restapicrud.repository;

import com.omar.restapicrud.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
