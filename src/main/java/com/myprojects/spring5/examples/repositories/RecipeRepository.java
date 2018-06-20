package com.myprojects.spring5.examples.repositories;

import com.myprojects.spring5.examples.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
