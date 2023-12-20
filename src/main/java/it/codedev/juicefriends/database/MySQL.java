package it.codedev.juicefriends.database;

import it.codedev.juicefriends.JuiceFriends;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL {
    private JuiceFriends main;
    @Getter private Connection connection;
    public MySQL(JuiceFriends main, String host, int port, String database, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,
                    username, password);
            main.getLogger().info("Database connection successful!");
        } catch (SQLException | ClassNotFoundException ex) {
            main.getLogger().severe("Database connection failed!");
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
            main.getLogger().info("Database disconnected successful!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void load() {
        execute("CREATE TABLE IF NOT EXISTS friends (uuid VARCHAR(48) PRIMARY KEY, friends VARCHAR)");
    }

    public void execute(String sql) {
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}