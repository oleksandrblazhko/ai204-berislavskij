package com.nuop.tscp.model.user;

import java.util.HashSet;
import java.util.List;
import javax.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(UserForm userForm) {
    User user = new User();
    user.setRole(userForm.getRole());
    user.setName(userForm.getName());
    user.setSurname(userForm.getSurname());
    user.setEmail(userForm.getEmail());
    user.setEmail(userForm.getMobile());
    return user;
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
