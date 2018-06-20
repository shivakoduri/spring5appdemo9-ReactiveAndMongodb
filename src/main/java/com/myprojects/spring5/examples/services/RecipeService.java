package com.myprojects.spring5.examples.services;

import com.myprojects.spring5.examples.commands.RecipeCommand;
import com.myprojects.spring5.examples.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(String l);

    void deleteById(String idToDelete);
}
