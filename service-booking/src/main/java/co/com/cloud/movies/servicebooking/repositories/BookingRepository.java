package co.com.cloud.movies.servicebooking.repositories;

public interface BookingRepository {
    List<Booking> findByUserId(Long usertId);
    Booking findByNumberBooking(String numberBooking);
}
