package com.sdaproject.watchIt.comment;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
