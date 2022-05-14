package ua.advanced.practice7_8.jdbc.dao;

import ua.advanced.practice7_8.jdbc.connections.ConnectionSetter;
import ua.advanced.practice7_8.model.Entity;

import java.util.List;

public abstract class BaseDAO<T extends Entity, K> {
    protected static ConnectionSetter connectionSetter = new ConnectionSetter();

    public abstract List<T> findAll();
    public abstract List<T> get(K parameter);
    public abstract void delete(K parameter);
    public abstract void update(T entity, K parameter);
}
