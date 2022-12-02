package com.sdaproject.watchIt.postComment;

import com.sdaproject.watchIt.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "post")
public class PostComment extends Comment {
    @Column
    private int postId;
}
