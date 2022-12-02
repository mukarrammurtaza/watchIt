package com.sdaproject.watchIt.police;

import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PoliceRepository extends CrudRepository<Police, Integer> {
    public Optional<Police> findByEmail(String email);

}
