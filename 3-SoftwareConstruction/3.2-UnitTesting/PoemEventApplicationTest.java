package com.nuop.tscp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nuop.tscp.model.booking.Booking;
import com.nuop.tscp.model.booking.BookingKey;
import com.nuop.tscp.model.booking.BookingRepository;
import com.nuop.tscp.model.booking.Status;
import com.nuop.tscp.model.exceptions.EntityNotFoundException;
import com.nuop.tscp.model.exceptions.ImproperStatusException;
import com.nuop.tscp.model.exceptions.ModificationForbiddenException;
import com.nuop.tscp.model.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class PoemEventApplicationTests {

	@InjectMocks
	private UserService userService;

	@MockBean
	private BookingRepository bookingRepository;

	static BookingKey bookingKey = new BookingKey(13L, 13L);
	

	@Test
	void testReplyWhenCorrect() {
		Assertions.assertTrue(true);
		Mockito.when(bookingRepository.findById(bookingKey)).thenReturn(Optional.of(Booking.
				builder()
				.id(bookingKey)
				.status(Status.PENDING)
				.build()));
		assertEquals(userService.reply(bookingKey, Status.ACCEPTED).getStatus(), Status.ACCEPTED);
	}

	@Test
	void testReplyWhenPassedStatusIsIncorrect() {
		assertThrows(ImproperStatusException.class, () -> userService.reply(bookingKey, Status.PENDING));
	}

	@Test
	void testReplyWhenBookingDoNotExist() {
		Mockito.when(bookingRepository.findById(bookingKey)).thenReturn(Optional.empty());
		assertThrows(EntityNotFoundException.class, () -> userService.reply(bookingKey, Status.ACCEPTED));
	}

	@Test
	void testReplyWhenStatusCanNotBeChanged() {
		Mockito.when(bookingRepository.findById(bookingKey)).thenReturn(Optional.of(Booking
				.builder()
				.id(bookingKey)
				.status(Status.DENIED)
				.build()));
		assertThrows(ModificationForbiddenException.class, () -> userService.reply(bookingKey, Status.ACCEPTED));
	}

}
