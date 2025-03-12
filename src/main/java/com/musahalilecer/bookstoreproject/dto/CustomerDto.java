package com.musahalilecer.bookstoreproject.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String username;
    private String password;
    private String image;
}
