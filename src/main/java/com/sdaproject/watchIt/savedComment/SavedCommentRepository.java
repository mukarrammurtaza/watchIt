package com.sdaproject.watchIt.savedComment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SavedCommentRepository extends CrudRepository<SavedComment, Integer> {
    public List<SavedComment> findSavedCommentByUserId(int userId);
}
