package com.savemoney.usermanagement.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name ="user", schema = "public")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_detail_id", referencedColumnName = "id")
    private UserDetail userDetail;

    @Column(name ="email", unique = true, nullable = false)
    private String email;

    @Column(name ="password", nullable = false)
    private String password;

    @Column(name ="is_valid", nullable = false)
    private Boolean isValid;

    @Column(name ="created_on", updatable = false)
    private LocalDateTime createdOn;

    @Column(name ="last_login")
    private LocalDateTime lastLogin;

    @PrePersist
    public void setDates(){
        LocalDateTime now = LocalDateTime.now();
        this.createdOn = now;
        this.lastLogin = now;
    }

    public User() {
    }

    public User(Long id, UserDetail userDetail, String email, String password, Boolean isValid, LocalDateTime createdOn, LocalDateTime lastLogin) {
        this.id = id;
        this.userDetail = userDetail;
        this.email = email;
        this.password = password;
        this.isValid = isValid;
        this.createdOn = createdOn;
        this.lastLogin = lastLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userDetail=" + userDetail +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isValid=" + isValid +
                ", createdOn=" + createdOn +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
