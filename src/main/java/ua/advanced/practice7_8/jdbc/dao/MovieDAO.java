package ua.advanced.practice7_8.jdbc.dao;

import ua.advanced.practice7_8.model.Movie;
import ua.advanced.practice7_8.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends BaseDAO<Movie, Integer> {
    private enum MovieRequests {
        SQL_SELECT_MOVIES("SELECT " +
                "M.ID AS Movie_ID, " +
                "Title, " +
                "DateOfCreation AS 'Date of creation',  " +
                "Country, " +
                "D.ID AS Director_ID, " +
                "Name, " +
                "Surname,  " +
                "Patronumic AS Patronymic, " +
                "DateOfBirth AS 'Date of birth' " +
                "FROM Movies M " +
                "INNER JOIN Directors D " +
                "ON M.ID = D.ID"),
        SQL_SELECT_MOVIE_BY_ID("SELECT " +
                "M.ID AS Movie_ID, " +
                "Title, " +
                "DateOfCreation AS 'Date of creation',  " +
                "Country, " +
                "D.ID AS Director_ID, " +
                "Name, " +
                "Surname,  " +
                "Patronumic AS Patronymic, " +
                "DateOfBirth AS 'Date of birth' " +
                "FROM Movies M " +
                "INNER JOIN Directors D " +
                "ON M.ID = D.ID" +
                "WHERE M.ID = ?"),
        SQL_DELETE_MOVIE_BY_ID("DELETE " +
                "FROM movies " +
                "WHERE ID = ?"),
        SQL_UPDATE_MOVIE_BY_ID("UPDATE movies " +
                "SET Title = ?, DateOfCreation = ?, Country = ? " +
                "WHERE ID = ?");

        private final String request;

        MovieRequests(String request) {
            this.request = request;
        }

        public String getRequest() {
            return request;
        }
    }

    @Override
    public List<Movie> findAll() throws DaoException {
        List<Movie> movies = new ArrayList<>();
        try {
            Statement st = connectionSetter.take().createStatement();
            ResultSet rs = st.executeQuery(MovieRequests.SQL_SELECT_MOVIES.getRequest());

            while (rs.next()) {
                int movieId = rs.getInt("Movie_ID");
                String title = rs.getString("Title");
                Date dateOfCreation = rs.getDate("Date of creation");
                String country = rs.getString("Country");
                int directorId = rs.getInt("Director_ID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronymic");
                Date dateOfBirth = rs.getDate("Date of birth");
                Person director = new Person(directorId, name, surname, patronymic, dateOfBirth);
                movies.add(new Movie(movieId, title, director, dateOfCreation, country));
            }
        } catch (SQLException e) {
            throw new DaoException("Class: MovieDAO - Method: findAll - database exception");
        } finally {
            connectionSetter.release();
        }
        return movies;
    }

    @Override
    public List<Movie> get(Integer id) throws DaoException {
        List<Movie> movie = new ArrayList<>();
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(MovieRequests.SQL_SELECT_MOVIE_BY_ID.getRequest());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int movieId = rs.getInt("Movie_ID");
                String title = rs.getString("Title");
                Date dateOfCreation = rs.getDate("Date of creation");
                String country = rs.getString("Country");
                int directorId = rs.getInt("Director_ID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronymic");
                Date dateOfBirth = rs.getDate("Date of birth");
                Person director = new Person(directorId, name, surname, patronymic, dateOfBirth);
                movie.add(new Movie(movieId, title, director, dateOfCreation, country));
            }
        } catch (SQLException e) {
            throw new DaoException("Class: MovieDAO - Method: get - database exception");
        } finally {
            connectionSetter.release();
        }
        return movie;
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(MovieRequests.SQL_DELETE_MOVIE_BY_ID.getRequest());
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Class: MovieDAO - Method: delete - database exception");
        } finally {
            connectionSetter.release();
        }
    }

    @Override
    public void update(Movie movie, Integer id) throws DaoException {
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(MovieRequests.SQL_UPDATE_MOVIE_BY_ID.getRequest());
            ps.setString(1, movie.getTitle());
            ps.setDate(2, movie.getDateOfCreation());
            ps.setString(3, movie.getCountry());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Class: MovieDAO - Method: update - database exception");
        } finally {
            connectionSetter.release();
        }
    }
}


