package com.example.bookdetail.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;


    @Data
    @NoArgsConstructor
    @Valid
    public class BookDto {
        String bookName;
        String autherName;
        String  bookDescription;
        String bookImg;
        int price;
        int quantity;
    }


