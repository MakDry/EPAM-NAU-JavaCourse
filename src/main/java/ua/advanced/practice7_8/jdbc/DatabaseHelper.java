package ua.advanced.practice7_8.jdbc;

import ua.advanced.practice7_8.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DatabaseHelper {
    private static final String RESOURCE_FILE = "practice7Database";
    private final String SQL_SELECT = "SELECT * FROM ";
    private final String SQL_DELETE_MOVIES = "DELETE FROM films WHERE Title = ?";
    private static ResourceBundle resource;
    private static Connection conn;

    static {
        try {
            resource = ResourceBundle.getBundle(RESOURCE_FILE);
            String url = resource.getString("db.url");
            String user = resource.getString("db.user");
            String pass = resource.getString("db.password");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Все фильмы, вышедшие на экран в текущем и прошлом году.
    public List<String> getModernMovies() throws SQLException {
        List<String> movies = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(SQL_SELECT.concat("films"));
        while (rs.next()) {
            String result = rs.getString("DateOfCreation");
            String[] date = result.split("-");
            if (Integer.parseInt(date[0]) > 2020)
                movies.add((String) rs.getObject("Title"));
        }
        return movies;
    }

    // Информация об актерах, снимавшихся в заданном фильме.
    public List<Person> getActorsByMovie(String title) throws SQLException {
        List<Person> actors = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT filmsactors.FilmTitle, actors.Name, actors.Surname, actors.Patronymic, actors.DateOfBirth " +
                    "FROM filmsactors " +
                    "INNER JOIN actors ON filmsactors.ActorName = actors.Name");
            while (rs.next()) {
                if (rs.getString("FilmTitle").equals(title)) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("Name");
                    String surname = rs.getString("Surname");
                    String patronymic = rs.getString("Patronymic");
                    String dateOfBirth = rs.getString("DateOfBirth");
                    //actors.add(new Person(id, name, surname, patronymic, dateOfBirth));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return actors;
    }

    // Информация об актерах, которые были режиссерами хотя бы одного из фильмов.
    public List<Person> getActorsAsDirector() throws SQLException {
        List<Person> directors = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT directors.Name AS DirectorName, actors.Name AS ActorName, actors.Surname, actors.Patronymic, actors.DateOfBirth\n" +
                    "FROM directors, actors\n" +
                    "WHERE actors.Name = directors.Name");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("ActorName");
                String surname = rs.getString("Surname");
                String patronymic = rs.getString("Patronymic");
                String dateOfBirth = rs.getString("DateOfBirth");
                //directors.add(new Person(id, name, surname, patronymic, dateOfBirth));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return directors;
    }

    // Удалить все фильмы, дата выхода которых была более заданного числа лет назад.
    public void deleteOldMovies(int yearsAgo) throws SQLException {
        try {
            Statement st = conn.createStatement();
            PreparedStatement ps = null;
            ResultSet rs = st.executeQuery(SQL_SELECT.concat("films"));
            while (rs.next()) {
                String result = rs.getString("DateOfCreation");
                String[] date = result.split("-");
                if (Integer.parseInt(date[0]) < (2022 - yearsAgo)) {
                    ps = conn.prepareStatement(SQL_DELETE_MOVIES);
                    ps.setString(1, rs.getString("Title"));
                    ps.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
