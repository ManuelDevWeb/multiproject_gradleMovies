package co.com.cloud.movies.serviceshowtime.entities;

import co.com.cloud.movies.serviceshowtime.model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="showtimes")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotNull(message = "El campo date no puede ser vacio")
    @Column(name="date")
    private Date date;

    // TO DO MOVIES
    @Transient
    private Movie movieId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime = (Showtime) o;
        return Objects.equals(id, showtime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
