package com.sdaproject.watchIt.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "police")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Police extends User{
    @Column(nullable = false, unique = true, length = 25)
    private String policeId;
}
