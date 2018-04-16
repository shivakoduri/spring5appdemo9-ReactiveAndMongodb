package com.myprojects.spring5.examples.repositories;

import com.myprojects.spring5.examples.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
