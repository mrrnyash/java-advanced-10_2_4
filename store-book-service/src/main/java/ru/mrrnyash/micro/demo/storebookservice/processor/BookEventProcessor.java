package ru.mrrnyash.micro.demo.storebookservice.processor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.mrrnyash.micro.demo.storebookservice.model.Book;

import java.util.function.Consumer;

@Component
@Slf4j
public class BookEventProcessor {
    @Bean
    public Consumer<Book> accept() {
        return book -> {
            Book b = new Book(book.getId(), book.getName(), book.getDescription(), book.getStatus(), book.getPrice());
            log.info("received book: {}", b);
        };
    }
}

