package co.com.cloud.movies.servicebooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "showtime_id")
    private String numberInvoice;
    @Column(name = "user_id")
    private Long UserId;
    @Transient
    private User user;
    @Transient
    private Showtime showtime;

    @Valid
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="booking_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<BookingItem> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
