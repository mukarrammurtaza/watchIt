package com.sdaproject.watchIt.Admin;

import com.sdaproject.watchIt.user.UserRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
}
