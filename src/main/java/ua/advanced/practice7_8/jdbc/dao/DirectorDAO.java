package ua.advanced.practice7_8.jdbc.dao;

import ua.advanced.practice7_8.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAO extends BaseDAO<Person, Integer> {
    private enum DirectorRequest {
        SQL_SELECT_DIRECTORS("SELECT * " +
                "FROM directors"),
        SQL_SELECT_DIRECTOR_BY_ID("SELECT * " +
                "FROM directors WHERE ID = ?"),
        SQL_DELETE_DIRECTOR_BY_ID("DELETE " +
                "FROM movies " +
                "WHERE ID = ?"),
        SQL_UPDATE_DIRECTOR_BY_ID("UPDATE directors " +
                "SET Name = ?, Surname = ?, Patronumic = ?, DateOfBirth = ? " +
                "WHERE ID = ?");

        private final String request;

        DirectorRequest(String request) {
            this.request = request;
        }

        public String getRequest() {
            return request;
        }
    }

    @Override
    public List<Person> findAll() throws DaoException {
        List<Person> directors = new ArrayList<>();
        try {
            Statement st = connectionSetter.take().createStatement();
            ResultSet rs = st.executeQuery(DirectorRequest.SQL_SELECT_DIRECTORS.getRequest());

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronumic");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                directors.add(new Person(id, name, surname, patronymic, dateOfBirth));
            }
        } catch (SQLException e) {
            throw new DaoException("Class: DirectorDAO - Method: findAll - database exception");
        } finally {
            connectionSetter.release();
        }
        return directors;
    }

    @Override
    public List<Person> get(Integer id) throws DaoException {
        List<Person> director = new ArrayList<>();
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(DirectorRequest.SQL_SELECT_DIRECTOR_BY_ID.getRequest());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int directorId = rs.getInt("ID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronumic");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                director.add(new Person(directorId, name, surname, patronymic, dateOfBirth));
            }
        } catch (SQLException e) {
            throw new DaoException("Class: DirectorDAO - Method: get - database exception");
        } finally {
            connectionSetter.release();
        }
        return director;
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(DirectorRequest.SQL_DELETE_DIRECTOR_BY_ID.getRequest());
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Class: DirectorDAO - Method: delete - database exception");
        } finally {
            connectionSetter.release();
        }
    }

    @Override
    public void update(Person director, Integer id) throws DaoException {
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(DirectorRequest.SQL_UPDATE_DIRECTOR_BY_ID.getRequest());
            ps.setString(1, director.getName());
            ps.setString(2, director.getSurname());
            ps.setString(3, director.getPatronymic());
            ps.setDate(4, director.getDateOfBirth());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Class: DirectorDAO - Method: update - database exception");
        } finally {
            connectionSetter.release();
        }
    }
}
