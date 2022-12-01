package com.sdaproject.watchIt.user;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sdaproject.watchIt.user.User;

import java.util.Optional;

@Repository
@Primary
public interface UserRepository extends CrudRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
}
