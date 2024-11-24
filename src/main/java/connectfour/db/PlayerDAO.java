package connectfour.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class PlayerDAO {
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public PlayerDAO() {
        try {

            Class.forName("org.h2.Driver");

            try (Connection connection =
                         DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE IF NOT EXISTS players "
                        + "(id INT AUTO_INCREMENT "
                        + "PRIMARY KEY, name VARCHAR(255) "
                        + "NOT NULL, win_count INT DEFAULT 0)");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hozzáad egy győzelmet a játékosnak.
     * @param playerName
     */
    public void addWin(final String playerName) {
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement selectStmt
                     = connection.prepareStatement(
                             "SELECT * FROM players WHERE name = ?");
             PreparedStatement insertStmt
                     = connection.prepareStatement(
                             "INSERT INTO players "
                             + "(name, win_count) VALUES (?, ?)");
             PreparedStatement updateStmt =
                     connection.prepareStatement(
                             "UPDATE players "
                                     + "SET win_count = ? WHERE name = ?")) {

            selectStmt.setString(1, playerName);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int winCount = rs.getInt("win_count") + 1;
                updateStmt.setInt(1, winCount);
                updateStmt.setString(2, playerName);
                updateStmt.executeUpdate();
            } else {
                insertStmt.setString(1, playerName);
                insertStmt.setInt(2, 1);
                insertStmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Visszaadja a játékosok győzelmeinek számát.
     * @return winCounts
     */
    public Map<String, Integer> getWinCounts() {
        Map<String, Integer> winCounts = new HashMap<>();
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT name, win_count FROM players")) {

            while (rs.next()) {
                winCounts.put(rs.getString("name"), rs.getInt("win_count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return winCounts;
    }
}
