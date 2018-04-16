package com.myprojects.spring5.examples.controller;

import com.myprojects.spring5.examples.domain.Category;
import com.myprojects.spring5.examples.domain.UnitOfMeasure;
import com.myprojects.spring5.examples.repositories.CategoryRepository;
import com.myprojects.spring5.examples.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){

        Optional<Category> categoryOpitonal = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category Id:" + categoryOpitonal.get().getId());
        System.out.println("Unit of Measure Id:" + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
