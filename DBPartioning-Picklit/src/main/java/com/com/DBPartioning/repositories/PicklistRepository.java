package com.com.DBPartioning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.com.DBPartioning.testme.Definition;
import com.com.DBPartioning.testme.DefinitionPK;

public interface PicklistRepository extends JpaRepository<Definition, DefinitionPK> {

}