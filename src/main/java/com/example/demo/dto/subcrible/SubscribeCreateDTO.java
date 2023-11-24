package com.example.demo.dto.subcrible;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscribeCreateDTO {

    private String vehicle;

    private String controlPlate;

    private String gps;

    private String type;

    private String sim;

    private String provider;

    private String service;

    private String des;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date enddate;

    private String url;

    private String fullname;

    private String email;

    private String phone;

    private String username;

    private String password;

    private Boolean status;

    private String wardCode;
}
