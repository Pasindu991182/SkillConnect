package com.skillconnect.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillconnect.server.model.User;

<<<<<<< HEAD
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUsername(String username);
=======
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
>>>>>>> origin/Member02
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
