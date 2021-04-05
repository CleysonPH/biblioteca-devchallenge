package com.cleysonph.booksapi.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BookDTO {

    @NotEmpty
    @Size(min = 3, max = 255)
    private String title;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String publisher;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String photo;

}
