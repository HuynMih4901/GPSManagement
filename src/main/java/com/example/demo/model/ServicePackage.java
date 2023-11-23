package com.example.demo.model;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
public class ServicePackage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;
  
  @Column(name = "des")
  private String des;

  @Column(name = "price")
  private int price;
  
  @Column(name = "time")
  private int time;

}
