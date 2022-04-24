package com.example.lab2.service;

import com.example.lab2.model.Author;
import com.example.lab2.model.Country;
import com.example.lab2.model.exception.AuthorNotFound;
import com.example.lab2.model.exception.CountryNotFound;
import com.example.lab2.model.exception.RequiredPropertyException;
import com.example.lab2.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll(){
        return this.countryRepository.findAll();
    }

    public Country findById(Long id){
        return this.countryRepository.findById(id).orElseThrow(CountryNotFound::new);
    }
    
    public Country create(Country country){
        if (country.getName().isEmpty() || country.getName().isBlank()){
            throw new RequiredPropertyException("Name is required!");
        }
        return this.countryRepository.save(country);
    }

    public Country edit(Long id,Country country){
        Country oldCountry=this.findById(id);
        if (country.getName().isEmpty() || country.getName().isBlank() ){
            throw new RequiredPropertyException("Name is required!");
        }
        oldCountry.setName(country.getName());
        oldCountry.setContinent(country.getContinent());

        return this.countryRepository.save(oldCountry);
    }
    
    public void delete(Long id){
        this.countryRepository.deleteById(id);
    }
    
}
