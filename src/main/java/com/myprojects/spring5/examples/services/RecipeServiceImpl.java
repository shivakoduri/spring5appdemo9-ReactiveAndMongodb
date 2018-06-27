package com.myprojects.spring5.examples.services;

import com.myprojects.spring5.examples.commands.RecipeCommand;
import com.myprojects.spring5.examples.converters.RecipeCommandToRecipe;
import com.myprojects.spring5.examples.converters.RecipeToRecipeCommand;
import com.myprojects.spring5.examples.domain.Recipe;
import com.myprojects.spring5.examples.exceptions.NotFoundException;
import com.myprojects.spring5.examples.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(String l) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        if(!recipeOptional.isPresent()){
//            throw  new RuntimeException("Recipe Not Found!");
            throw new NotFoundException("Recipe Not Found. For Id value: "+l);
        }
        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
       Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

       Recipe savedRecipe = recipeRepository.save(detachedRecipe);
       log.debug("Saved RecipeId:" + savedRecipe.getId());
       return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(String l) {

        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(findById(l));

        //enhance command object with id value
        if(recipeCommand.getIngredients() != null && recipeCommand.getIngredients().size() > 0){
            recipeCommand.getIngredients().forEach(rc -> {
                rc.setRecipeId(recipeCommand.getId());
            });
        }

        return recipeCommand;
    }

    @Override
    public void deleteById(String idToDelete) {
        recipeRepository.deleteById(idToDelete);
    }
}
