package com.myprojects.spring5.examples.repositories.reactive;

import com.myprojects.spring5.examples.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
