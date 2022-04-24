package com.example.lab2.config;

import com.example.lab2.model.Author;
import com.example.lab2.model.Book;
import com.example.lab2.model.CategoryType;
import com.example.lab2.model.Country;
import com.example.lab2.repository.AuthorRepository;
import com.example.lab2.repository.BookRepository;
import com.example.lab2.repository.CountryRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Component
class DataInitializer{

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    DataInitializer(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    private void init() {

        Country macedonia=new Country();
        macedonia.setName("Macedonia");
        macedonia.setContinent("Europe");
        macedonia=countryRepository.save(macedonia);
        Country serbia=new Country();
        serbia.setName("Serbia");
        serbia.setContinent("Europe");
        serbia=countryRepository.save(serbia);

        Author blagica=new Author();
        blagica.setName("Blagica");
        blagica.setSurname("Penkova");
        blagica.setCountry(macedonia);
        blagica=authorRepository.save(blagica);

        Book terapija=new Book();
        terapija.setName("Terapija");
        terapija.setAuthor(blagica);
        terapija.setCategoryType(CategoryType.THRILER);
        terapija.setAvailableCopies(5);
        terapija=bookRepository.save(terapija);
        terapija=new Book();
        terapija.setName("Harry Potter 1");
        terapija.setAuthor(blagica);
        terapija.setCategoryType(CategoryType.THRILER);
        terapija.setAvailableCopies(5);
        terapija=bookRepository.save(terapija);
        terapija=new Book();
        terapija.setName("Harry Potter 2");
        terapija.setAuthor(blagica);
        terapija.setCategoryType(CategoryType.THRILER);
        terapija.setAvailableCopies(5);
        terapija=bookRepository.save(terapija);
        terapija=new Book();
        terapija.setName("Harry Potter 3");
        terapija.setAuthor(blagica);
        terapija.setCategoryType(CategoryType.THRILER);
        terapija.setAvailableCopies(5);
        terapija=bookRepository.save(terapija);
        terapija=new Book();
        terapija.setName("Harry Potter 4");
        terapija.setAuthor(blagica);
        terapija.setCategoryType(CategoryType.THRILER);
        terapija.setAvailableCopies(5);
        terapija=bookRepository.save(terapija);
        terapija=new Book();
        terapija.setName("Harry Potter 5");
        terapija.setAuthor(blagica);
        terapija.setCategoryType(CategoryType.THRILER);
        terapija.setAvailableCopies(5);
        terapija=bookRepository.save(terapija);
        terapija=new Book();
        terapija.setName("Harry Potter 6");
        terapija.setAuthor(blagica);
        terapija.setCategoryType(CategoryType.THRILER);
        terapija.setAvailableCopies(5);
        terapija=bookRepository.save(terapija);
        terapija=new Book();
        terapija.setName("Harry Potter 7");
        terapija.setAuthor(blagica);
        terapija.setCategoryType(CategoryType.THRILER);
        terapija.setAvailableCopies(5);
        terapija=bookRepository.save(terapija);
        terapija=new Book();
        terapija.setName("Harry Potter 8");
        terapija.setAuthor(blagica);
        terapija.setCategoryType(CategoryType.THRILER);
        terapija.setAvailableCopies(5);
        terapija=bookRepository.save(terapija);

    }

}