package co.com.cloud.movies.servicemovie.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotEmpty(message = "El campo title no puede ser vacio")
    @Column(name="title")
    private String title;

    @NotEmpty(message = "El campo director no puede ser vacio")
    @Column(name="director")
    private String director;

    @NotNull(message = "El campo rating no puede ser vacio")
    @Min(1)
    @Max(5)
    @Column(name="rating")
    private Integer rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
