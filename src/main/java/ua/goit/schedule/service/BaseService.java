package ua.goit.schedule.service;

import ua.goit.schedule.model.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface BaseService <T extends BaseEntity<V>,V>{

    Collection<T> findAll();

    Optional<T> findById(V id);

    T save(T t);

    void deleteById(V id);

}
