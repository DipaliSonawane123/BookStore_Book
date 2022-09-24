package com.example.bookdetail.service;

import com.example.bookdetail.Dto.BookDto;
import com.example.bookdetail.model.Book;

import java.util.List;

public interface IBookService {

    String insertBookDetails(BookDto bookDto);

    List<Book> getall();

    Book FindById(int id);

    Book getByBook(String bookName);

    void getBookbyId(int id);

    String editById(int id, BookDto bookDTO);

    List<Book> sortPriceLowToHigh();

    List<Book> sortPriceHighToLow();


    Book changeBookQty(int cartId, int quantity);

    Book FindByIds(int id);
}
