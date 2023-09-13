package com.carservice.data.enums;

import com.carservice.data.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;


//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "role")
public enum /*class*/ Role implements GrantedAuthority {
//    @Id
//    private Long id;
//
//    private String authority;
//
//    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
//    private Set<User> users;
    CUSTOMER,
    EMPLOYEE;
    @Override
    public String getAuthority() {
        return name();
    }
}
