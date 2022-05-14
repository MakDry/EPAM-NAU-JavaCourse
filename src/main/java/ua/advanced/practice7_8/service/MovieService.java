package ua.advanced.practice7_8.service;

import ua.advanced.practice7_8.jdbc.dao.DaoException;
import ua.advanced.practice7_8.jdbc.dao.MovieDAO;
import ua.advanced.practice7_8.jdbc.repository.MovieRepositoryImpl;
import ua.advanced.practice7_8.model.Movie;

import java.sql.Date;
import java.util.List;

public class MovieService extends BaseService<Movie, Integer> {

    private MovieRepositoryImpl mri;

    public MovieService() {
        super(new MovieDAO());
        mri = new MovieRepositoryImpl();
    }

    @Override
    public List<Movie> findAll() throws DaoException {
        return dao.findAll();
    }

    @Override
    public List<Movie> getBy(Integer id) throws DaoException {
        return dao.get(id);
    }

    @Override
    public void deleteBy(Integer id) throws DaoException {
        dao.delete(id);
    }

    @Override
    public void updateBy(Movie movie, Integer id) throws DaoException {
        dao.update(movie, id);
    }

    public List<Movie> findAllNewMovies() throws DaoException {
        return mri.getNewMovies();
    }

    public void deleteOldMovies(Date date) throws DaoException {
        mri.deleteOldMovies(date);
    }
}
