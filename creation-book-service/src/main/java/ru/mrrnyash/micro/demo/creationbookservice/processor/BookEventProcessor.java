package ru.mrrnyash.micro.demo.creationbookservice.processor;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import ru.mrrnyash.micro.demo.creationbookservice.model.Book;

import java.util.LinkedList;
import java.util.function.Supplier;

@Component
@EnableScheduling
@Slf4j
@AllArgsConstructor
public class BookEventProcessor {

    private final LinkedList<Book> bookCreationEventSource;

    @Bean
    public Supplier<Book> get() {
        return () -> {
            Book book = bookCreationEventSource.peek();
            if (bookCreationEventSource.peek() != null) {
                log.info("sending new book: {}", bookCreationEventSource.peek());
                bookCreationEventSource.poll();
                return book;
            }
            return null;
        };
    }
}
