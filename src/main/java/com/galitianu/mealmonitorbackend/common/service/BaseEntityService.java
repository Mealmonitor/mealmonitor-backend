package com.galitianu.mealmonitorbackend.common.service;

import com.galitianu.mealmonitorbackend.common.persistence.BaseEntity;
import com.galitianu.mealmonitorbackend.common.persistence.BaseRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
public abstract class BaseEntityService<E extends BaseEntity> extends BaseService {
    protected abstract BaseRepository<E> getRepository();
    public Optional<E> findById(UUID id) {
        return getRepository().findById(id);
    }
    public List<E> findAll() {
        return (List<E>) getRepository().findAll();
    }
    public E save(E e) {
        return getRepository().save(e);
    }
    public void delete(E e) {
        getRepository().delete(e);
    }
}
