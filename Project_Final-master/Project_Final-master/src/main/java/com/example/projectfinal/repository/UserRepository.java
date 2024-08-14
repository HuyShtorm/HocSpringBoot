package com.example.projectfinal.repository;

import com.example.projectfinal.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> , JpaSpecificationExecutor<User>  {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
