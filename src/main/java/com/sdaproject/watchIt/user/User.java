package com.sdaproject.watchIt.user;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.STRING
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;

    @Column
    private Boolean blocked;

    @Column(nullable = false, length = 15)
    private String cnic;
}
