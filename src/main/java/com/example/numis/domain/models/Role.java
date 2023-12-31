package com.example.numis.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name="roles",indexes = {
        @Index(columnList = "name",unique = true)
})
public class Role implements GrantedAuthority {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    @NotNull
    @NotEmpty
    @Column(name = "name",length = 32,unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<User> users;

    @Override
    public String getAuthority() {
        return name;
    }
}
