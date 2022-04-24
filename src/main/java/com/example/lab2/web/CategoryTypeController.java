package com.example.lab2.web;

import com.example.lab2.service.CategoryTypeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/category-type", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryTypeController {
    private final CategoryTypeService categoryTypeService;

    public CategoryTypeController(CategoryTypeService categoryTypeService) {
        this.categoryTypeService = categoryTypeService;
    }

    @GetMapping
    public List<String> getAllCategories() {
        return categoryTypeService.getAllCategories();
    }
}
