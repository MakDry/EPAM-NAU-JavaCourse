package ua.advanced.practice7_8.jdbc.dao;

import ua.advanced.practice7_8.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO extends BaseDAO<Person, Integer> {
    private enum ActorRequest {
        SQL_SELECT_ACTORS("SELECT * " +
                "FROM actors"),
        SQL_SELECT_ACTOR_BY_ID("SELECT * " +
                "FROM actors WHERE ID = ?"),
        SQL_DELETE_ACTOR_BY_ID("DELETE " +
                "FROM actors " +
                "WHERE ID = ?"),
        SQL_UPDATE_ACTOR_BY_ID("UPDATE actors " +
                "SET Name = ?, Surname = ?, Patronymic = ?, DateOfBirth = ? " +
                "WHERE ID = ?");

        private final String request;

        ActorRequest(String request) {
            this.request = request;
        }

        public String getRequest() {
            return request;
        }
    }

    @Override
    public List<Person> findAll() throws DaoException {
        List<Person> actors = new ArrayList<>();
        try {
            Statement st = connectionSetter.take().createStatement();
            ResultSet rs = st.executeQuery(ActorRequest.SQL_SELECT_ACTORS.getRequest());

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronymic");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                actors.add(new Person(id, name, surname, patronymic, dateOfBirth));
            }
        } catch (SQLException e) {
            throw new DaoException("Class: ActorDAO - Method: findAll - database exception");
        } finally {
            connectionSetter.release();
        }
        return actors;
    }

    @Override
    public List<Person> get(Integer id) throws DaoException {
        List<Person> actor = new ArrayList<>();
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(ActorRequest.SQL_SELECT_ACTOR_BY_ID.getRequest());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int directorId = rs.getInt("ID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronymic");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                actor.add(new Person(directorId, name, surname, patronymic, dateOfBirth));
            }
        } catch (SQLException e) {
            throw new DaoException("Class: ActorDAO - Method: get - database exception");
        } finally {
            connectionSetter.release();
        }
        return actor;
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(ActorRequest.SQL_DELETE_ACTOR_BY_ID.getRequest());
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Class: ActorDAO - Method: delete - database exception");
        } finally {
            connectionSetter.release();
        }
    }

    @Override
    public void update(Person actor, Integer id) throws DaoException {
        try {
            PreparedStatement ps = connectionSetter.take().prepareStatement(ActorRequest.SQL_UPDATE_ACTOR_BY_ID.getRequest());
            ps.setString(1, actor.getName());
            ps.setString(2, actor.getSurname());
            ps.setString(3, actor.getPatronymic());
            ps.setDate(4, actor.getDateOfBirth());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Class: ActorDAO - Method: update - database exception");
        } finally {
            connectionSetter.release();
        }
    }
}
