package com.example.data.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserSearchDto {

    private String email;

    private String firstName;

    private String middleName;

    private String lastName;

    private String fullName;

    private String gender;

    private Date birthDate;

    private String phNumber;

    private Integer experience;

    private double currSalary;

    private double exptSalary;

    private Byte isEnalbe;

    private Integer roleId;

    private Integer compId;

    private Byte isOwner;

    private int pageSize;
    private int pageNumber;

}
