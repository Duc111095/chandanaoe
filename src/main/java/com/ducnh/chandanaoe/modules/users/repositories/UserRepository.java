package com.ducnh.chandanaoe.modules.users.repositories;

import com.ducnh.chandanaoe.modules.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
