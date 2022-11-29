package com.sdaproject.watchIt.user;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sdaproject.watchIt.user.User;
@Repository
@Primary
public interface UserRepository extends CrudRepository<User, Integer> {
}
