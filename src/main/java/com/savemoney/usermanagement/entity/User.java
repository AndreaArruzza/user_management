package com.savemoney.usermanagement.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="USER")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_detail_id")
    private UserDetail userDetail;

    @Column(name ="email", unique = true)
    private String email;

    @Column(name ="password", unique = true)
    private String password;

    @Column(name ="is_valid", unique = true)
    private Boolean isValid;

    public User() {
    }

    public User(Long id, UserDetail userDetail, String email, String password, Boolean isValid) {
        this.id = id;
        this.userDetail = userDetail;
        this.email = email;
        this.password = password;
        this.isValid = isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

}
