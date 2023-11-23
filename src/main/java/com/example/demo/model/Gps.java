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
@Table(name = "gps")
public class Gps {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "url")
  private String url;

  @Column(name = "name")
  private String name;
  
  @Column(name = "code")
  private String code;
  
  @Column(name = "provider")
  private int provider;
  
  @Column(name = "inventory")
  private int inventory;
  
  @Column(name = "des")
  private String des;
  
  @Column(name = "quantity")
  private int quantity;
  
  @Column(name = "importPrice")
  private int importPrice;
  
  @Column(name = "salePrice")
  private int salePrice;
}
