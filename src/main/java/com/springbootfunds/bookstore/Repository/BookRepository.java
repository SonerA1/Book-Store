package com.springbootfunds.bookstore.Repository;

import com.springbootfunds.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
