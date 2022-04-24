package com.example.lab2.web;

import java.util.List;
import com.example.lab2.model.Book;
import com.example.lab2.model.Country;
import com.example.lab2.service.BookService;
import com.example.lab2.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{id}")
    public Country getCountry(@PathVariable Long id){
        return countryService.findById(id);
    }

    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getAll();
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country){
        return countryService.create(country);
    }

    @PutMapping("/{id}")
    public Country editCountry(@RequestBody Country country,@PathVariable Long id){
        return countryService.edit(id,country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id){
        countryService.delete(id);
    }

}
