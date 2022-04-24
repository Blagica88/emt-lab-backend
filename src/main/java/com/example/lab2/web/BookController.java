package com.example.lab2.web;

import com.example.lab2.model.Book;
import com.example.lab2.model.dto.BookCreationDto;
import com.example.lab2.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.findById(id);
    }

    @GetMapping
    public Page<Book> getAllBooks(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
        return bookService.getAll(page, size);
    }

    @PostMapping
    public Book createBook(@RequestBody BookCreationDto book){
        return bookService.create(book);
    }

    @PutMapping("/{id}")
    public Book editBook(@RequestBody BookCreationDto book,@PathVariable Long id){
        return bookService.edit(id,book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }

    @PatchMapping("/{id}")
    public Book markAsTakenBook(@PathVariable Long id,@RequestParam Boolean isTaken){
        return bookService.markAsTaken(id,isTaken);
    }
}
