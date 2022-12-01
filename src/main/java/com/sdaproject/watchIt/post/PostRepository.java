package com.sdaproject.watchIt.post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
    public List<Post> findAllByOrderByDateDesc();
}
