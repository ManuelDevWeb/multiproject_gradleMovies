package co.com.cloud.movies.servicebooking.services;


import co.com.cloud.movies.servicebooking.entities.Booking;

import java.util.List;
public interface BookingService {
    void save(Booking booking);
    void delete(Booking booking);
    List<Booking> findAll();
    Booking findById(Long id);
}
