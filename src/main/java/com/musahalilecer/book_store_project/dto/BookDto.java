package com.musahalilecer.book_store_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private Integer page;
    private Double price;
    private String image;
    private Integer authorId;
    private Integer languageId;
    private Set<Integer> genreIds;
    private Set<Long> customerIds;


}
