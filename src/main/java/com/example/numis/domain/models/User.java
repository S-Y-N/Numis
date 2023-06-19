package com.example.numis.domain.models;

import com.example.numis.annotations.ValidEmail;
import com.example.numis.annotations.ValidPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ValidPassword
@Table(name = "users",indexes = {
        @Index(columnList = "username",unique = true),
        @Index(columnList = "email",unique = true),
        @Index(columnList = "password",unique = true),
        @Index(columnList = "username, email, password", unique = true)
})
public class User implements UserDetails {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name = "username",length = 128,nullable = false)
    private String username;

    @NotNull
    @NotEmpty
    @Setter
    @ValidEmail
    @Column(name = "email",length = 128,nullable = false)
    private String email;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name = "password",length = 256, nullable = false)
    private String password;

    @Transient
    @Setter
    private String passwordConfirmation;

    @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
