package com.example.bookdetail.Dto;

import com.example.bookdetail.model.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto {
    private String message;
    private Object object;
    public ResponseDto(String s, Book response) {
        this.message = s;
        this.object = response;

    }

    public ResponseDto(String s, Object response) {
        this.message = s;
        this.object = response;
    }

}
