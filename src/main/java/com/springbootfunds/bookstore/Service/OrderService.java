package com.springbootfunds.bookstore.Service;

import com.springbootfunds.bookstore.Repository.OrderRepository;
import com.springbootfunds.bookstore.model.Order;
import com.springbootfunds.bookstore.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    private final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final BookService bookService;
    private final OrderRepository orderRepository;

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    public Order putAnOrder(List<Integer> bookIdList, String userName){
        Double totalPrice = bookIdList.stream()
                .map(bookService::findBookById)
                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
                .reduce(0.0,Double::sum);

        Order order = Order.builder()
                .totalPrice(totalPrice)
                .userName(userName)
                .build();
        return orderRepository.save(order);


    }

}
