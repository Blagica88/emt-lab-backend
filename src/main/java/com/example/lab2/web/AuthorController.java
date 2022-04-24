package com.example.lab2.web;

import com.example.lab2.model.Author;
import com.example.lab2.model.dto.AuthorCreationDto;
import com.example.lab2.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id){
        return authorService.findById(id);
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAll();
    }

    @PostMapping
    public Author createAuthor(@RequestBody AuthorCreationDto author) {
        return authorService.create(author);
    }

    @PutMapping("/{id}")
    public Author editAuthor(@RequestBody AuthorCreationDto author,@PathVariable Long id){
        return authorService.edit(id,author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.delete(id);
    }

}
