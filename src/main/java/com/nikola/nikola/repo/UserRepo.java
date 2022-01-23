package com.nikola.nikola.repo;

import com.nikola.nikola.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
