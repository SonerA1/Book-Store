package com.springbootfunds.bookstore;

import com.springbootfunds.bookstore.Repository.BookRepository;
import com.springbootfunds.bookstore.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Arrays;

@SpringBootApplication
@EntityScan("com.springbootfunds.bookstore.model")
public class BookStoreApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public BookStoreApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Book book1 =Book.builder()
				.name("Lord Of The Rigs Fellowship of the Ring")
				.author("J.R.R. Tolkien")
				.price(100.0)
				.stock(10).build();
		Book book2 =Book.builder()
				.name("Lord Of The Rigs The Two Thrones")
				.author("J.R.R. Tolkien")
				.price(110.0)
				.stock(10).build();
		Book book3 =Book.builder()
				.name("Lord Of The Rings Return of the King ")
				.author("J.R.R. Tolkien")
				.price(115.5)
				.stock(10).build();
		bookRepository.saveAll(Arrays.asList(book1,book2,book3));
	}
}
