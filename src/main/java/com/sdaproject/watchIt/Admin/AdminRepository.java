package com.sdaproject.watchIt.Admin;

import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends UserRepository {
    User findByEmail(String email);
}
