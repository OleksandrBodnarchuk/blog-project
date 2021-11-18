package pl.alex.devnote.domain.category;

import pl.alex.devnote.config.DataSourceProvider;
import pl.alex.devnote.domain.common.MainDAO;


import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDAO extends MainDAO {

    public List<Category> findAllCategories() {
        final String getAllSQL = "SELECT id, name, description FROM category";
        try (Connection connection = getConnection();
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

    public Optional<Category> findCategoryById(int categoryId){
        final String getCategoryById = "SELECT id, name, description FROM category WHERE id=?";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(getCategoryById)){
            statement.setInt(1,categoryId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Category category = mapResultRow(resultSet);
                return Optional.of(category);
            }else {
                return Optional.empty();
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    private Category mapResultRow(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new Category(id,name,description);
    }
}
