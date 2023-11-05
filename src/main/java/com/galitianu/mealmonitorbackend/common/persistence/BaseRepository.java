package com.galitianu.mealmonitorbackend.common.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T> extends CrudRepository<T, UUID> {

}