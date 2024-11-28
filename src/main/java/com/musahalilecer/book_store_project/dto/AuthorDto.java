package com.musahalilecer.book_store_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String image;
}
