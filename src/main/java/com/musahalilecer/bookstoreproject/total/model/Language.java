package com.musahalilecer.bookstoreproject.total.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Language")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Language {
    public Language(String language) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "language")
    private String language;
}
