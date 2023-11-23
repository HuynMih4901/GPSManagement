package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Subscribe")
public class Subscribe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "vehicle")
	private String vehicle;

	@Column(name = "controlPlate")
	private String controlPlate;

	@Column(name = "gps")
	private String gps;

	@Column(name = "type")
	private String type;

	@Column(name = "sim")
	private String sim;

	@Column(name = "provider")
	private String provider;

	@Column(name = "service")
	private String service;

	@Column(name = "des")
	private String des;

	@Column(name = "startdate")
	private Date startDate;

	@Column(name = "enddate")
	private Date enddate;

	@Column(name = "url")
	private String url;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private Boolean status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ward_code", referencedColumnName = "code")
	private Ward ward;
}
