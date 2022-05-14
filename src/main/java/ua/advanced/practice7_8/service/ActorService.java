package ua.advanced.practice7_8.service;

import ua.advanced.practice7_8.jdbc.dao.ActorDAO;
import ua.advanced.practice7_8.jdbc.dao.DaoException;
import ua.advanced.practice7_8.jdbc.repository.ActorRepositoryImpl;
import ua.advanced.practice7_8.model.Person;

import java.util.List;

public class ActorService extends BaseService<Person, Integer> {

    private ActorRepositoryImpl ari;

    public ActorService() {
        super(new ActorDAO());
        ari = new ActorRepositoryImpl();
    }

    @Override
    public List<Person> findAll() throws DaoException {
        return dao.findAll();
    }

    @Override
    public List<Person> getBy(Integer id) throws DaoException {
        return dao.get(id);
    }

    @Override
    public void deleteBy(Integer id) throws DaoException {
        dao.delete(id);
    }

    @Override
    public void updateBy(Person actor, Integer id) throws DaoException {
        dao.update(actor, id);
    }

    public List<Person> getActorsByFilmId(Integer id) throws DaoException {
        return ari.getMovieActors(id);
    }

    public List<Person> getActorsFilmedOften(Integer id) throws DaoException {
        return ari.getPopularActor(id);
    }

    public List<Person> getDirectorActors() throws DaoException {
        return ari.getDirectorActors();
    }
}
