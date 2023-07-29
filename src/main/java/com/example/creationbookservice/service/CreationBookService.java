package com.example.creationbookservice.service;

import com.example.creationbookservice.model.Book;
import com.example.creationbookservice.util.BookGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Slf4j
@Service
@AllArgsConstructor
public class CreationBookService {

    private final LinkedList<Book> bookCreationEvents;
    private final BookGenerator bookGenerator;

    @Scheduled(fixedRate = 10000)
    public void generateBook() {
        Book book = bookGenerator.createNewBook();
        bookCreationEvents.add(book);
    }
}
