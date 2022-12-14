package com.ashikur.spring.shoppingcartweb.controllers;

import com.ashikur.spring.shoppingcartweb.dtos.response.pages.HomeDtoResponse;
import com.ashikur.spring.shoppingcartweb.models.Category;
import com.ashikur.spring.shoppingcartweb.models.Tag;
import com.ashikur.spring.shoppingcartweb.services.CategoryService;
import com.ashikur.spring.shoppingcartweb.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("")
@RestController
public class PagesController {

    @Autowired
    private final CategoryService categoriesService;
    @Autowired
    private final TagService tagService;

    @Autowired
    public PagesController(CategoryService categoriesService, TagService tagService) {
        this.categoriesService = categoriesService;
        this.tagService = tagService;
    }

    @GetMapping(path = {"", "/home"})
    public HomeDtoResponse home() {
        List<Category> categories = categoriesService.getAllSummary();
        List<Tag> tags = tagService.getAllTags();
        return HomeDtoResponse.build(tags, categories);
    }
}
