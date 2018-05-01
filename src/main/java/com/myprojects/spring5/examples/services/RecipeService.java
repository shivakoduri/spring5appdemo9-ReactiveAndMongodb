package com.myprojects.spring5.examples.services;

import com.myprojects.spring5.examples.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);
}
