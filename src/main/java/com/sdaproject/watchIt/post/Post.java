package com.sdaproject.watchIt.post;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false, length = 50)
    private String category;

    @Column
    private String text;

    @Column
    private String location;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private boolean approved;
}
