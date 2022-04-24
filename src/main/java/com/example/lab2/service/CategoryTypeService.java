package com.example.lab2.service;

import com.example.lab2.model.CategoryType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryTypeService {

    public List<String> getAllCategories() {
        List<String> categoryTypes = new ArrayList<>();

        categoryTypes.add(CategoryType.THRILER.toString());
        categoryTypes.add(CategoryType.BIOGRAPHY.toString());
        categoryTypes.add(CategoryType.CLASSICS.toString());
        categoryTypes.add(CategoryType.DRAMA.toString());
        categoryTypes.add(CategoryType.FANTASY.toString());
        categoryTypes.add(CategoryType.HISTORY.toString());
        categoryTypes.add(CategoryType.NOVEL.toString());

        return categoryTypes;
    }

}
