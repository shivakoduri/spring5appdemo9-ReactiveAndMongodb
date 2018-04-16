package com.myprojects.spring5.examples.repositories;

import com.myprojects.spring5.examples.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
