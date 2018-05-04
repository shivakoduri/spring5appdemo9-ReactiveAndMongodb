package com.myprojects.spring5.examples.services;

import com.myprojects.spring5.examples.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
