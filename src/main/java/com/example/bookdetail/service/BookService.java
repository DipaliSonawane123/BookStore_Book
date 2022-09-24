package com.example.bookdetail.service;

import com.example.bookdetail.Dto.BookDto;
import com.example.bookdetail.exception.BookException;
import com.example.bookdetail.model.Book;
import com.example.bookdetail.repo.BookRepo;
import com.example.bookdetail.util.EmailSenderService;
import com.example.bookdetail.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    EmailSenderService emailSender;

    @Override
    public String insertBookDetails(BookDto bookDto) {
        Book book = new Book(bookDto);
        Book newBook = bookRepo.save(book);
        String token = tokenUtil.createToken(book.getId());
        return token;
    }

    @Override
    public List<Book> getall() {
        List<Book> book = bookRepo.findAll();
        return book;
    }

    @Override
    public Book FindById(int cartId) {
        Optional<Book> book = bookRepo.findById(cartId);
        if (book.isPresent())
            return book.get();
        else {
            throw new BookException("id is not found");
        }
    }

    @Override
    public Book getByBook(String bookName) {
        Book bookList = bookRepo.findByName(bookName);
        if (bookList != null) {
            bookRepo.findByName("bookname");
            return bookList;

        } else throw new BookException(" Book with name  is  found!");

    }

    @Override
    public void getBookbyId(int id) {
        Optional<Book> book = bookRepo.findById(id);
        if (book.isPresent()) {
            bookRepo.deleteById(id);

        } else throw new BookException("Id:" + id + " not present");

    }

    @Override
    public String editById(int id, BookDto Bookdto) {
        Book editbook = bookRepo.findById(id).orElse(null);
        if (editbook != null) {
            editbook.setBookName(Bookdto.getBookName());
            editbook.setAutherName(Bookdto.getAutherName());
            editbook.setBookDescription(Bookdto.getBookDescription());
            editbook.setBookImg(Bookdto.getBookImg());
            editbook.setPrice(Bookdto.getPrice());
            editbook.setQuantity(Bookdto.getQuantity());
            bookRepo.save(editbook);
            String token = tokenUtil.createToken(editbook.getId());
            return token;
        } else
            throw new BookException("Id:" + id + " is not present ");
    }

    @Override
    public List<Book> sortPriceLowToHigh() {
        List<Book> getSortedList = bookRepo.getSortedListOfBooksInAsc();
        return getSortedList;

    }

    @Override
    public List<Book> sortPriceHighToLow() {
        List<Book> getSortedListInDesc = bookRepo.getSortedListOfBooksInDesc();
        return getSortedListInDesc;

    }

    @Override
    public Book changeBookQty(int id, int qunatity) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book == null) {
            throw new BookException("Id is not found");
        }
        book.setQuantity(qunatity);
        return bookRepo.save(book);
    }

    @Override
    public Book FindByIds(int id) {
        Optional<Book> book = bookRepo.findById(id);
        if (book.isPresent())
            return book.get();
        else {
         return null;
        }
}
}












