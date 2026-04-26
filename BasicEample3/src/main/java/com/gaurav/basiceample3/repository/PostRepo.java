package com.gaurav.basiceample3.repository;

import com.gaurav.basiceample3.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {
}
