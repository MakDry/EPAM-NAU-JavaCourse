package ua.advanced.practice7_8.service;

import ua.advanced.practice7_8.jdbc.dao.DaoException;
import ua.advanced.practice7_8.jdbc.dao.DirectorDAO;
import ua.advanced.practice7_8.model.Person;

import java.util.List;

public class DirectorService extends BaseService<Person, Integer> {

    public DirectorService() {
        super(new DirectorDAO());
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
    public void updateBy(Person director, Integer id) throws DaoException {
        dao.update(director, id);
    }
}
