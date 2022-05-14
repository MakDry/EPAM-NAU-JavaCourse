package ua.advanced.practice7_8.jdbc.repository;

import ua.advanced.practice7_8.model.Entity;

import java.util.List;

abstract class ActorRepository<T extends Entity, K> extends BaseRepository {

    // Вывести информацию об актерах, снимавшихся в заданном фильме.
    abstract List<T> getMovieActors(K parameter);

    // Вывести информацию об актерах, снимавшихся как минимум в N фильмах.
    abstract List<T> getPopularActor(K parameter);

    // Вывести информацию об актерах, которые были режиссерами хотя бы одного из фильмов.
    abstract List<T> getDirectorActors();
}
