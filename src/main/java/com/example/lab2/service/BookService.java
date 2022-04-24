package com.example.lab2.service;

import com.example.lab2.model.Author;
import com.example.lab2.model.Book;
import com.example.lab2.model.dto.BookCreationDto;
import com.example.lab2.model.exception.AuthorNotFound;
import com.example.lab2.model.exception.BookNotFound;
import com.example.lab2.model.exception.RequiredPropertyException;
import com.example.lab2.repository.AuthorRepository;
import com.example.lab2.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAll(){
        return this.bookRepository.findAll();
    }

    public Page<Book> getAll(int page,int size){
        return this.bookRepository.findAll(PageRequest.of(page,size));
    }

    public Book findById(Long id){
        return this.bookRepository.findById(id).orElseThrow(BookNotFound::new);
    }

    public Book create(BookCreationDto book){
        if (book.getName().isEmpty() || book.getName().isBlank()){
            throw new RequiredPropertyException("Name is required!");
        }
        Author author=this.authorRepository.findById(book.getAuthor()).orElseThrow(AuthorNotFound::new);
        Book newBook=new Book();
        newBook.setName(book.getName());
        newBook.setAuthor(author);
        newBook.setCategoryType(book.getCategoryType());
        newBook.setAvailableCopies(book.getAvailableCopies());
        return this.bookRepository.save(newBook);
    }

    public Book edit(Long id,BookCreationDto book){
        Book oldBook=this.findById(id);
        if (book.getName().isEmpty() || book.getName().isBlank() || book.getAuthor()==null || book.getAvailableCopies()==null || book.getCategoryType()==null){
            throw new RequiredPropertyException("Everything is required!");
        }
        Author author=this.authorRepository.findById(book.getAuthor()).orElseThrow(AuthorNotFound::new);
        oldBook.setName(book.getName());
        oldBook.setAuthor(author);
        oldBook.setAvailableCopies(book.getAvailableCopies());
        oldBook.setCategoryType(book.getCategoryType());

        return this.bookRepository.save(oldBook);
    }
    
    public void delete(Long id){
        this.bookRepository.deleteById(id);
    }

    public Book markAsTaken(Long id,Boolean isTaken){
        Book book=this.findById(id);

        if (isTaken){
            book.setAvailableCopies(book.getAvailableCopies()-1);
        }
        else book.setAvailableCopies(book.getAvailableCopies()+1);

        return this.bookRepository.save(book);
    }

}
