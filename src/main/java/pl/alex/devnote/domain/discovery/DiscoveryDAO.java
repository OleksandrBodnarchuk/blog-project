package pl.alex.devnote.domain.discovery;


import pl.alex.devnote.domain.common.MainDAO;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiscoveryDAO extends MainDAO {


    public List<Discovery> findAllDiscoveries() {
        final String getAllSQL = "SELECT id, title, url, description, date_added, category_id FROM discovery";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            List<Discovery> discoveries = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(getAllSQL);
            while (resultSet.next()) {
                Discovery discovery = mapResultRow(resultSet);
                discoveries.add(discovery);
            }
            return discoveries;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Discovery> findByCategoryId(int categoryId) {
        final String query = "SELECT id, title, url, description, date_added, category_id " +
                "FROM discovery WHERE category_id=?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, categoryId);
            List<Discovery> discoveries = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Discovery discovery = mapResultRow(resultSet);
                discoveries.add(discovery);
            }
            return discoveries;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Discovery mapResultRow(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String url = resultSet.getString("url");
        String description = resultSet.getString("description");
        LocalDateTime dateAdded = resultSet.getTimestamp("date_added").toLocalDateTime();
        Integer categoryId = resultSet.getInt("category_id");
        return new Discovery(id, title, url, description, dateAdded, categoryId);
    }
}
