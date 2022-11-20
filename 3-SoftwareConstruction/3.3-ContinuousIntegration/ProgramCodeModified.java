/**
 * Some info about package.
 */
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

/**
 * It is service for interactions with users.
 */
@Service
public class UserService {


  /**
   * User DAO.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * Booking DAO.
   */
  @Autowired
  private BookingRepository bookingRepository;

  /**
   * Creates user.
   *
   * @param  userForm  UserForm from web-page
   * @return      the object of created user
   */

  public User createUser(final UserForm userForm) {
    User user = new User();
    user.setRole(userForm.getRole());
    user.setName(userForm.getName());
    user.setSurname(userForm.getSurname());
    user.setEmail(userForm.getEmail());
    user.setEmail(userForm.getMobile());
    return user;
  }

  /**
   * Replies to booking request.
   *
   * @param  bookingId  id of booking
   * @param  status  status of reply
   * @return      the resulting booking
   */

  public Booking reply(final BookingKey bookingId, final Status status) {
    if (!(status.equals(Status.DENIED) || status.equals(Status.ACCEPTED))) {
      throw new ImproperStatusException();
    }
    Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(EntityNotFoundException::new);
    if (!booking.getStatus().equals(Status.PENDING)) {
      throw new ModificationForbiddenException();
    }
    booking.setStatus(status);
    return bookingRepository.save(booking);
  }

  /**
   * Saves user to database.
   *
   * @param  user user to be saved
   * @return      saved user
   */

  public User saveUser(final User user) {
    return userRepository.save(user);
  }

  /**
   * Get all requests.
   *
   * @param  userId id of user
   * @return      list of booking requests
   */

  public List<Booking> getRequests(final Long userId) {
    return bookingRepository.findForUser(userId);
  }

  /**
   * Get all requests.
   *
   * @return      list of booking users
   */

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
