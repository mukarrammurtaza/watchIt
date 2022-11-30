package com.sdaproject.watchIt.police;

import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliceRepository extends UserRepository {
    User findByEmail(String email);
}
