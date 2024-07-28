package com.todolist_java.domain.user.repository;

import com.todolist_java.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
