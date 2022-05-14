package ua.advanced.practice7_8.jdbc.repository;

import ua.advanced.practice7_8.jdbc.dao.DaoException;
import ua.advanced.practice7_8.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorRepositoryImpl extends ActorRepository<Person, Integer> {
    private enum ActorRequest {
        SQL_GET_MOVIE_ACTORS("SELECT A.ID AS 'Actor ID', A.Name, A.Surname, A.Patronymic, A.DateOfBirth " +
                "FROM filmsactors FA " +
                "INNER JOIN Actors A " +
                "ON FA.Movie_ID = ?"),
        SQL_GET_ACTOR_DIRECTOR("SELECT A.ID AS 'Actor ID', A.Name, A.Surname, A.Patronymic, A.DateOfBirth " +
                "FROM actors A " +
                "INNER JOIN Directors D " +
                "ON A.Name = D.Name"),
        SQL_GET_OFTEN_FILMING_ACTORS("SELECT " +
                "A.ID, Name, Surname, Patronymic, DateOfBirth, " +
                "COUNT(A.Name) " +
                "FROM filmsactors FA " +
                "INNER JOIN actors A " +
                "ON FA.Actor_ID = A.ID " +
                "GROUP BY A.Name " +
                "HAVING COUNT(A.Name) >= ?");

        private final String request;

        ActorRequest(String request) {
            this.request = request;
        }

        public String getRequest() {
            return request;
        }
    }

    @Override
    public List<Person> getMovieActors(Integer movieId) throws DaoException {
        List<Person> actors = new ArrayList<>();
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(ActorRequest.SQL_GET_MOVIE_ACTORS.getRequest());
            ps.setInt(1, movieId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Actor ID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronymic");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                actors.add(new Person(id, name, surname, patronymic, dateOfBirth));
            }
        } catch (SQLException e) {
            throw new DaoException("Class: ActorRepositoryImpl - Method: getMovieActors - database exception");
        } finally {
            connectionSetter.release();
        }
        return actors;
    }

    @Override
    public List<Person> getPopularActor(Integer numberOfMovies) throws DaoException {
        List<Person> actors = new ArrayList<>();
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(ActorRequest.SQL_GET_OFTEN_FILMING_ACTORS.getRequest());
            ps.setInt(1, numberOfMovies);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Actor ID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronymic");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                actors.add(new Person(id, name, surname, patronymic, dateOfBirth));
            }
        } catch (SQLException e) {
            throw new DaoException("Class: ActorRepositoryImpl - Method: getPopularActors - database exception");
        } finally {
            connectionSetter.release();
        }
        return actors;
    }

    @Override
    public List<Person> getDirectorActors() {
        List<Person> actors = new ArrayList<>();
        try {
            Statement st = connectionSetter.take().createStatement();
            ResultSet rs = st.executeQuery(ActorRequest.SQL_GET_ACTOR_DIRECTOR.getRequest());

            while (rs.next()) {
                int id = rs.getInt("Actor ID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronymic");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                actors.add(new Person(id, name, surname, patronymic, dateOfBirth));
            }
        } catch (SQLException e) {
            throw new DaoException("Class: ActorRepositoryImpl - Method: getDirectorActors - database exception");
        } finally {
            connectionSetter.release();
        }
        return actors;
    }
}
