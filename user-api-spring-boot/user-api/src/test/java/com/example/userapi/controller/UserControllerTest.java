package com.example.userapi.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.userapi.model.User;
import com.example.userapi.service.UserService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockitoBean // Use @MockBean if you are on Spring Boot 3.3 or earlier
  private UserService userService;

  @Test
  void getUsers_ShouldReturnJsonArrayOfUsers() throws Exception {
    // Arrange
    List<User> mockUsers =
        List.of(
            new User("John Doe", "john.doe@example.com"),
            new User("Jane Smith", "jane.smith@example.com"));
    when(userService.getUsers()).thenReturn(mockUsers);

    // Act & Assert
    mockMvc
        .perform(get("/api/users"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()").value(2))
        .andExpect(jsonPath("$[0].name").value("John Doe"))
        .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
        .andExpect(jsonPath("$[1].name").value("Jane Smith"));

    verify(userService, times(1)).getUsers();
  }
}
