package com.sdaproject.watchIt.police;

import com.sdaproject.watchIt.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "police")
public class Police extends User {
    @Column(length = 30)
    private String policeID;
}
