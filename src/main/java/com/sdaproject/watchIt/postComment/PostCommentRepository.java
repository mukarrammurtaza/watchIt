package com.sdaproject.watchIt.postComment;

import com.sdaproject.watchIt.postComment.PostComment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostCommentRepository extends CrudRepository<PostComment, Integer> {
    public List<PostComment> findPostCommentByPostId (int postId);
}
