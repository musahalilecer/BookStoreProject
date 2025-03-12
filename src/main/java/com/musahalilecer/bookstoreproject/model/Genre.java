package com.musahalilecer.bookstoreproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Genre")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "Genre")
    private String genre;
}
