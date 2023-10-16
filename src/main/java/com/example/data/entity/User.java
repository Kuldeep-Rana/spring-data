package com.example.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "users",schema = "app")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Formula("concat(first_name, middle_name, last_name)")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "phone_number")
    private String phNumber;

    @Column(name = "summary")
    private String summary;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "profile_img")
    private String profImg;

    @Column(name = "current_salary")
    private double currSalary;

    @Column(name = "expected_salary")
    private double exptSalary;

    @Column(name = "is_enable")
    private Byte isEnalbe;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "company_id")
    private Integer compId;

    @Column(name = "is_owner")
    private Byte isOwner;


}