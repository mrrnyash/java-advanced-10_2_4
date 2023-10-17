package ru.mrrnyash.micro.demo.checkbookservice.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import ru.mrrnyash.micro.demo.checkbookservice.model.Book;

import java.util.function.Function;


@EnableScheduling
@Component
@Slf4j
public class CheckBookEventProcessor {
    @Bean
    public Function<Book, Book> apply() {
        return book -> {
            book.setStatus("checked");
            log.info("received book: {}", book);
            log.info("checked book: " + book.getId());
            return book;
        };
    }
}
