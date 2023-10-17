package ru.mrrnyash.micro.demo.creationbookservice.util;


import org.springframework.stereotype.Component;
import ru.mrrnyash.micro.demo.creationbookservice.model.Book;

import java.util.Random;

@Component
public class BookGenerator {

    private final Random rnd = new Random();

    public Book createNewBook() {
        int randomBookId = rnd.nextInt(10);
        String randomName = "Book name: " + randomBookId;
        String randomDescription = "Book description: " + randomBookId;
        String status = "unchecked";
        int randomPrice = randomBookId++;

        return Book.builder()
                .id(randomBookId)
                .name(randomName)
                .description(randomDescription)
                .status(status)
                .price(randomPrice)
                .build();
    }
}
