package pl.alex.devnote.domain.user;

import pl.alex.devnote.config.DataSourceProvider;
import pl.alex.devnote.domain.common.MainDAO;

import java.sql.*;
import java.time.LocalDate;

public class UserDAO extends MainDAO {

    public void save(User user) {
        saveUser(user);
        saveUserRole(user);
    }

    public void saveUser(User user) {
        final String query = "insert into user (username, email, registration_date, password) VALUES (?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setObject(3, user.getRegistrationDate());
            statement.setString(4, user.getPassword());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            while (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUserRole(User user) {
        final String query = "insert into user_role (username) values (?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
