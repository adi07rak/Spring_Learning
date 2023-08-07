package com.test.adi.learningspring.util;

import com.test.adi.learningspring.business.ReservationService;
import com.test.adi.learningspring.business.RoomReservation;
import com.test.adi.learningspring.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
//    private final RoomRepository roomRepository;
//    private final GuestRepository guestRepository;
//    private final ReservationRepository reservationRepository;
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
//        this.roomRepository = roomRepository;
//        this.guestRepository = guestRepository;
//        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
//        Iterable<Room> rooms = this.roomRepository.findAll();
//        rooms.forEach(System.out::println);
//        Iterable<Guest> guests = this.guestRepository.findAll();
//        guests.forEach(System.out::println);
        Iterable<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);


    }
}
