package ua.advanced.practice7_8.jdbc.repository;

import ua.advanced.practice7_8.jdbc.dao.DaoException;
import ua.advanced.practice7_8.model.Movie;
import ua.advanced.practice7_8.model.Person;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl extends MovieRepository<Movie, Date>{
    private enum MovieRequest {
        SQL_GET_NEW_MOVIES("SELECT M.ID AS 'Movie ID', Title, DateOfCreation, Country, D.ID AS 'Director ID', Name, Surname, Patronumic AS Patronymic, DateOfBirth " +
                "FROM Movies M " +
                "INNER JOIN Directors D " +
                "WHERE M.DateOfCreation > ?"),
        SQL_DELETE_OLD_MOVIES("DELETE " +
                "FROM movies " +
                "WHERE DateOfCreation < ?");

        private final String request;

        MovieRequest(String request) {
            this.request = request;
        }

        public String getRequest() {
            return request;
        }
    }

    @Override
    public List<Movie> getNewMovies() throws DaoException {
        List<Movie> movies = new ArrayList<>();
        int currentYear = new java.util.Date().getYear() + 1898;
        String dateValue = Integer.toString(currentYear).concat("-00-00");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(dateValue);
            Date sqlDate = new Date(utilDate.getTime());
            PreparedStatement ps = connectionSetter.take().prepareStatement(MovieRequest.SQL_GET_NEW_MOVIES.getRequest());
            ps.setDate(1, sqlDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int movieId = rs.getInt("Movie ID");
                String title = rs.getString("Title");
                Date dateOfCreation = rs.getDate("DateOfCreation");
                String country = rs.getString("Country");
                int directorId = rs.getInt("Director ID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronymic");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                Person director = new Person(directorId, name, surname, patronymic, dateOfBirth);
                movies.add(new Movie(movieId, title, director, dateOfCreation, country));
            }
        } catch (SQLException | ParseException e) {
            throw new DaoException("Class: MovieRepositoryImpl - Method: getNewMovies - database exception");
        } finally {
            connectionSetter.release();
        }
        return movies;
    }

    @Override
    public void deleteOldMovies(Date date) {
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(MovieRequest.SQL_DELETE_OLD_MOVIES.getRequest());
            ps.setDate(1, date);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Class: MovieRepositoryImpl - Method: deleteOldMovies - database exception");
        } finally {
            connectionSetter.release();
        }
    }
}
