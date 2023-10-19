/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.customer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
   @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
   private long id;
   private String name;
   private String phone;

   private String iban;
   private String surname;
   private String address;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer",
           cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CustomerProduct> producto;

   @Transient
   private List<?> transactions;
}
