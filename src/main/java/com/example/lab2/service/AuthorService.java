package com.example.lab2.service;

import com.example.lab2.model.Author;
import com.example.lab2.model.Country;
import com.example.lab2.model.dto.AuthorCreationDto;
import com.example.lab2.model.exception.AuthorNotFound;
import com.example.lab2.model.exception.CountryNotFound;
import com.example.lab2.model.exception.RequiredPropertyException;
import com.example.lab2.repository.AuthorRepository;
import com.example.lab2.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorService(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    public List<Author> getAll(){
        return this.authorRepository.findAll();
    }

    public Author findById(Long id){
        return this.authorRepository.findById(id).orElseThrow(AuthorNotFound::new);
    }

    public Author create(AuthorCreationDto author){
        if (author.getName().isEmpty() || author.getName().isBlank() || author.getSurname().isEmpty() || author.getSurname().isBlank()){
            throw new RequiredPropertyException("Name and Surname are required!");
        }
        Country country=this.countryRepository.findById(author.getCountry()).orElseThrow(CountryNotFound::new);
        Author newAuthor=new Author();
        newAuthor.setName(author.getName());
        newAuthor.setSurname(author.getSurname());
        newAuthor.setCountry(country);
        return this.authorRepository.save(newAuthor);
    }

    public Author edit(Long id,AuthorCreationDto author){
        Author oldAuthor=this.findById(id);
        if (author.getName().isEmpty() || author.getName().isBlank() || author.getSurname().isEmpty() || author.getSurname().isBlank()){
            throw new RequiredPropertyException("Name and Surname are required!");
        }
        Country country=this.countryRepository.findById(author.getCountry()).orElseThrow(CountryNotFound::new);

        oldAuthor.setName(author.getName());
        oldAuthor.setSurname(author.getSurname());
        oldAuthor.setCountry(country);

        return this.authorRepository.save(oldAuthor);
    }

    public void delete(Long id){
        this.authorRepository.deleteById(id);
    }

}
