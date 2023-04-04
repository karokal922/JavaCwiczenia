package com.example.aplikacjanagit.manager;

import com.example.aplikacjanagit.model.Book;
import com.example.aplikacjanagit.model.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookManager {
    private BookRepo bookRepo;
    @Autowired
    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public Optional<Book> findAllById(Long id)
    {
        return bookRepo.findById(id);
    }
    public Iterable<Book> findAll()
    {
        return bookRepo.findAll();
    }
    public Book save(Book book)
    {
        return bookRepo.save(book);
    }
    public void delete(Long id){
        bookRepo.deleteById(id);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Book(1L,"ONIE", LocalDate.of(2000,2,29)));
        save(new Book(2L,"OTAK", LocalDate.of(2001,3,29)));
    }
}