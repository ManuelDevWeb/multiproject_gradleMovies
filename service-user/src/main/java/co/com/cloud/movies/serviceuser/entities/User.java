package co.com.cloud.movies.serviceuser.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotEmpty(message = "El campo name no puede ser vacio")
    @Column(name="name")
    private String name;

    @NotEmpty(message = "El campo lastname no puede ser vacio")
    @Column(name="lastname")
    private String lastname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
