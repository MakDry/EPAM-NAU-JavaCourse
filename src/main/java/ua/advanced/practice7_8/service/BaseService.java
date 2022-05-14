package ua.advanced.practice7_8.service;

import ua.advanced.practice7_8.jdbc.dao.BaseDAO;
import ua.advanced.practice7_8.model.Entity;

import java.util.List;

abstract class BaseService <T extends Entity, K> {
    protected BaseDAO<T, K> dao;

    protected BaseService(BaseDAO<T, K> dao) {
        this.dao = dao;
    }

    public abstract List<T> findAll();
    public abstract List<T> getBy(K parameter);
    public abstract void deleteBy(K parameter);
    public abstract void updateBy(T object, K parameter);
}
