package com.savemoney.usermanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name ="user_detail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    public UserDetail() {
    }

    public UserDetail(Long id, String name, String surname, LocalDate birthDate, String birthPlace, String address, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
