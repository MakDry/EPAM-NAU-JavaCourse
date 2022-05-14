package ua.advanced.practice7_8.jdbc.repository;

import ua.advanced.practice7_8.model.Entity;

import java.util.List;

abstract class MovieRepository<T extends Entity, K> extends BaseRepository {
    // Найти все фильмы, вышедшие на экран в текущем и прошлом году.
    abstract List<T> getNewMovies();

    // Удалить все фильмы, дата выхода которых была более заданного числа лет назад
    abstract void deleteOldMovies(K parameter);
}
