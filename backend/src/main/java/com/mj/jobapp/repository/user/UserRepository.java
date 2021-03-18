package com.mj.jobapp.repository.user;

import java.util.Optional;

import com.mj.jobapp.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.name =:name ")
    Optional<User> findByName(String name);

}
