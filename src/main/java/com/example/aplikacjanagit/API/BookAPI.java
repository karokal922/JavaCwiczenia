package com.example.aplikacjanagit.API;

import com.example.aplikacjanagit.manager.BookManager;
import com.example.aplikacjanagit.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookAPI {
    //private List<VideoCassete> videoCassetes;
    private BookManager bookManager;
    @Autowired
    public BookAPI(BookManager book)
    {
        this.bookManager = book;
    }
    /*public VideoCasseteApi(){
        videoCassetes=new ArrayList<>();
        videoCassetes.add(new VideoCassete(1L,"ONIE", LocalDate.of(2000,2,29)));
        videoCassetes.add(new VideoCassete(2L,"OTAK", LocalDate.of(2001,3,29)));
    }*/

    @GetMapping("/all")
    public Iterable<Book> getAll(){
        return bookManager.findAll();
    }
    @GetMapping
    public Optional<Book> getById(@RequestParam long index)
    {
        return bookManager.findAllById(index);
        /*Optional<VideoCassete> first= videoCassetes.stream().filter(element->element.getId()==index).findFirst();
        return  first.get();*/
    }
    @PostMapping
    public Book addVideo(@RequestBody Book book){
        return bookManager.save(book);
    }
    @PutMapping
    public Book updateVideo(@RequestBody Book book){
        return bookManager.save(book);
    }
    @DeleteMapping
    public void deleteVideo(@RequestParam long index){
        bookManager.delete(index);
    }
}
