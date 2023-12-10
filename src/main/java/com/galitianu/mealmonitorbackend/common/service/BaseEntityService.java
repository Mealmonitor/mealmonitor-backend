package com.galitianu.mealmonitorbackend.common.service;

import com.galitianu.mealmonitorbackend.common.mapper.BaseModelEntityMapper;
import com.galitianu.mealmonitorbackend.common.persistence.BaseEntity;
import com.galitianu.mealmonitorbackend.common.persistence.BaseRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Getter
@Setter
public abstract class BaseEntityService<M extends BaseEntityModel, E extends BaseEntity> extends BaseService {
    protected abstract BaseRepository<E> getRepository();

    protected abstract BaseModelEntityMapper<M, E> getMapper();

    public Optional<M> findById(UUID id) {
        return getMapper().mapToModel(getRepository().findById(id));
    }

    public List<M> findAll() {
        Iterable<E> iterable = getRepository().findAll();
        return StreamSupport.stream(iterable.spliterator(), false).map(getMapper()::mapToModel).toList();
    }

    public M save(M m) {
        E e = getMapper().mapToEntity(m);
        e = getRepository().save(e);
        return getMapper().mapToModel(e);
    }

    public void delete(M m) {
        E e = getMapper().mapToEntity(m);
        getRepository().delete(e);
    }

}

