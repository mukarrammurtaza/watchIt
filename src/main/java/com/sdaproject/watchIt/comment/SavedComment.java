package com.sdaproject.watchIt.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "savedComment")
public class SavedComment extends Comment{

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private int userId;
}
