package com.springbootfunds.bookstore.Service;

import com.springbootfunds.bookstore.Repository.BookRepository;
import com.springbootfunds.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Optional<Book> findBookById(Integer bookId){
        return bookRepository.findById(bookId);
    }

}
