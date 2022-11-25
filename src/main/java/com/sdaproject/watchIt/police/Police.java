package com.sdaproject.watchIt.police;

import com.sdaproject.watchIt.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "police")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Police extends User {
    int policeID;
}
