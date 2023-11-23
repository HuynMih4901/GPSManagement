package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "code", nullable = false, unique = true)
  private String code;

  @Column(name = "created_date")
  private LocalDate createdDate;

  @Column(name = "total_price")
  private Double totalPrice;

  @Column(name = "quantity")
  private Integer quantity;
}
