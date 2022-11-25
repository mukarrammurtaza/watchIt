package com.sdaproject.watchIt.Admin;

import com.sdaproject.watchIt.user.User;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User {
    @Column(nullable = false)
    private boolean admin;

}
