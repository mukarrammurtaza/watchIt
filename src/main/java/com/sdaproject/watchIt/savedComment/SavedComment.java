package com.sdaproject.watchIt.savedComment;

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
@DiscriminatorValue(value = "saved")
public class SavedComment extends Comment {
    @Column
    private int userId;
}
