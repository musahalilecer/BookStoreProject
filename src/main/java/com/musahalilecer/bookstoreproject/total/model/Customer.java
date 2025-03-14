package com.musahalilecer.bookstoreproject.total.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "image")
    private String image;
}
