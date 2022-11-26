package com.sdaproject.watchIt.user;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public interface UserRepository extends CrudRepository<User, java.lang.Integer> {
}
