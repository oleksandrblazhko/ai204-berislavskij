package com.nuop.tscp.model.user;

import java.util.List;

import com.nuop.tscp.model.booking.Booking;
import com.nuop.tscp.model.booking.BookingKey;
import com.nuop.tscp.model.booking.BookingRepository;
import com.nuop.tscp.model.booking.Status;
import com.nuop.tscp.model.exceptions.EntityNotFoundException;
import com.nuop.tscp.model.exceptions.ImproperStatusException;
import com.nuop.tscp.model.exceptions.ModificationForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BookingRepository bookingRepository;

  public User createUser(UserForm userForm) {
    User user = new User();
    user.setRole(userForm.getRole());
    user.setName(userForm.getName());
    user.setSurname(userForm.getSurname());
    user.setEmail(userForm.getEmail());
    user.setEmail(userForm.getMobile());
    return user;
  }

  public Booking reply(BookingKey bookingId, Status status) {
    if (!(status.equals(Status.DENIED) || status.equals(Status.ACCEPTED))) {
      throw new ImproperStatusException();
    }
    Booking booking = bookingRepository.findById(bookingId).orElseThrow(EntityNotFoundException::new);
    if (!booking.getStatus().equals(Status.PENDING)) {
      throw new ModificationForbiddenException();
    }
    booking.setStatus(status);
    return bookingRepository.save(booking);
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public List<Booking> getRequests(Long userId) {
    return bookingRepository.findForUser(userId);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
