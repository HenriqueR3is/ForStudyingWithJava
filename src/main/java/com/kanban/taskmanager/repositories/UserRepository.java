package com.kanban.taskmanager.repositories;

import com.kanban.taskmanager.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String>{
    UserDetails findByLogin(String login);
}
