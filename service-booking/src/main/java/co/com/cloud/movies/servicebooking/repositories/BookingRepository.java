package co.com.cloud.movies.servicebooking.repositories;

import co.com.cloud.movies.servicebooking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Long>{
}
