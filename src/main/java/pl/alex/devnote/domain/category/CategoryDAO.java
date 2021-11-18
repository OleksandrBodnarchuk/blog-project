package pl.alex.devnote.domain.category;

import pl.alex.devnote.config.DataSourceProvider;


import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final DataSource dataSource;

    public CategoryDAO() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> findAllCategories() {
        final String getAllSQL = "SELECT id, name, description FROM category";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            List<Category> categories = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(getAllSQL);
            while (resultSet.next()) {
                Category category = mapResultRow(resultSet);
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Category mapResultRow(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new Category(id,name,description);
    }
}
