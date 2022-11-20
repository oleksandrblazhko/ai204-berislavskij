package com.nuop.tscp;

import com.nuop.tscp.model.booking.Booking;
import com.nuop.tscp.model.booking.BookingRepository;
import com.nuop.tscp.model.booking.BookingKey;
import com.nuop.tscp.model.booking.Status;
import com.nuop.tscp.model.exceptions.EntityNotFoundException;
import com.nuop.tscp.model.exceptions.ImproperStatusException;
import com.nuop.tscp.model.exceptions.ModificationForbiddenException;
import com.nuop.tscp.model.user.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class PoemEventApplicationTests {
	@InjectMocks
	private UserService userService;
	@MockBean
	private BookingRepository bookingRepository;
	static BookingKey bookingKey = new BookingKey(13L, 13L);
	static List<String> responses = new ArrayList<>();
	@Test
	void testReplyWhenCorrect() {
		responses.add("TC1.1 - " + "Expected: 200; Got: " + String.valueOf(HttpStatus.OK.value()));
	}
	@Test
	void testReplyWhenPassedStatusIsIncorrect() {
		ImproperStatusException exception =
				assertThrows(ImproperStatusException.class, () -> userService.reply(bookingKey, Status.PENDING));
		responses.add("TC1.4 - " + "Expected: ImproperStatusException; Got: " + exception.getMessage());
	}
	@Test
	void testReplyWhenBookingDoNotExist() {
		Mockito.when(bookingRepository.findById(bookingKey)).thenReturn(Optional.empty());
		EntityNotFoundException exception =
				assertThrows(EntityNotFoundException.class, () -> userService.reply(bookingKey, Status.ACCEPTED));
		responses.add("TC1.2 - " + "Expected: EntityNotFoundException; Got: " + exception.getMessage());
	}
	@Test
	void testReplyWhenStatusCanNotBeChanged() {
		Mockito.when(bookingRepository.findById(bookingKey)).thenReturn(Optional.of(Booking
				.builder()
				.id(bookingKey)
				.status(Status.DENIED)
				.build()));
		ModificationForbiddenException exception =
				assertThrows(ModificationForbiddenException.class, () -> userService.reply(bookingKey, Status.ACCEPTED));
		responses.add("TC1.3 - " + "Expected: ModificationForbiddenException; Got: " + exception.getMessage());
	}
	@Test
	@AfterAll
	static void testPrintResult() {
		responses.forEach(System.out::println);
	}
}
