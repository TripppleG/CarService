package com.carservice.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;


@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public abstract class User implements UserDetails {
    @Id
    @Column(name = "email")
    @Email(regexp = ".+[@].+[\\.].+", message = "Invalid email format!")
    @NotBlank(message = "The email cannot be empty!")
    protected String email;

    @Column(name = "first_name")
    @NotBlank(message = "The first name cannot be empty!")
    protected String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "The last name cannot be empty!")
    protected String lastName;

    @Column(name = "phone_number")
    @NotBlank(message = "The phone number cannot be empty!")
    @Pattern(regexp = "^\\+359\\d{9}$", message = "The phone number must be in the format +359xxxxxxxxx!")
    protected String phoneNumber;

    @Column(name = "password")
    @NotBlank(message = "The password cannot be empty!")
    @Size(min = 8, max = 64, message = "The password must contain at least 8 characters!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least 1 uppercase letter, 1 lowercase letter and 1 digit!")
    protected String password;

    @ManyToMany
    protected Set<Role> authorities;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public String getPassword(){
        return password;
    }
}