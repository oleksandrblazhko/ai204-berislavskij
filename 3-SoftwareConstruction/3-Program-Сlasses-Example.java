package com.nuop.tscp.model.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nuop.tscp.model.apartment.Apartment;
import com.nuop.tscp.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {

    @EmbeddedId
    BookingKey id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("apartmentId")
    @JoinColumn(name = "apartment_id")
    @ToString.Exclude
    private Apartment apartment;

    @Column(name = "start_time")
    LocalDateTime timeStart;
    @Column(name = "end_time")
    LocalDateTime timeEnd;
    @Column(name = "booking_status")
    Status status;
}
