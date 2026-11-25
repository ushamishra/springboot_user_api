package com.example.userapi.service;

import com.example.userapi.model.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public List<User> getUsers() {
    return List.of(
        new User("John Doe", "john.doe@example.com"),
        new User("Jane Smith", "jane.smith@example.com"),
        new User("Alice Johnson", "alice.johnson@example.com"));
  }
}
