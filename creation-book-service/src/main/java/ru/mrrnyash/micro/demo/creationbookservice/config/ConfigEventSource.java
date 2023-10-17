package ru.mrrnyash.micro.demo.creationbookservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mrrnyash.micro.demo.creationbookservice.model.Book;

import java.util.LinkedList;

@Configuration
public class ConfigEventSource {

    @Bean
    public LinkedList<Book> createBookCreationEventSource() {
        return new LinkedList<>();
    }
}
