package ru.mrrnyash.micro.demo.creationbookservice.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mrrnyash.micro.demo.creationbookservice.model.Book;
import ru.mrrnyash.micro.demo.creationbookservice.util.BookGenerator;

import java.util.LinkedList;

@Service
@AllArgsConstructor
@Slf4j
public class CreationBookService {

    private final LinkedList<Book> bookCreationEvents;
    private final BookGenerator bookGenerator;

    @Scheduled(fixedRate = 10000)
    public void generateBooks() {
        Book book = bookGenerator.createNewBook();
        bookCreationEvents.add(book);
    }
}
