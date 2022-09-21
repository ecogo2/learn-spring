package com.test.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
// obična klasa koja služi da se iz requesta mapiraju ovi atributu u objekat
public class BookDTO {

    private Long id;
    private String name;
    private int numberOfPages;

}
