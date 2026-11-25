package com.example.userapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.userapi.model.User;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceTest {

  private UserService userService;

  @BeforeEach
  void setUp() {
    userService = new UserService();
  }

  @Test
  void getUsers_ShouldReturnListOfThreeUsers() {
    // Act
    List<User> users = userService.getUsers();

    // Assert
    assertNotNull(users);
    assertEquals(3, users.size());
    assertEquals("John Doe", users.get(0).getName());
    assertEquals("john.doe@example.com", users.get(0).getEmail());
  }
}
