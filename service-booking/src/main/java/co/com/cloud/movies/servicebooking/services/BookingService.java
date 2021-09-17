package co.com.cloud.movies.servicebooking.services;


import java.util.List;
public interface BookingService {
    void save(Booking booking);
    void delete(Booking booking);
    List<Booking> findAll();
    Booking findById(Long id);
    Booking findByNumberBooking(String numberBooking);
}
