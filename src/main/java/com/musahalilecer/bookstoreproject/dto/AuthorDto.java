package com.musahalilecer.bookstoreproject.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AuthorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String image;
}
