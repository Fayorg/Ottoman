package me.fayorg.ottoman.utils;

import org.mariadb.jdbc.MariaDbPoolDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    /**
     * Credentials to connect to the database (btw this is on my private network. It cannot be reached from any external IP).
     */
    private final String host = "10.193.100.111";
    private final String port = "3306";
    private final String database = "Ottoman";

    private MariaDbPoolDataSource pool;

    public Database(String username, String password) throws SQLException {
        this.pool = new MariaDbPoolDataSource("jdbc:mariadb://" + this.host + "/" + this.database + "?user=" + username + "&maxPoolSize=10");
        this.pool.setUser(username);
        this.pool.setPassword(password);
    }

    public ResultSet query(String sql) throws SQLException {
        return this.pool.getConnection().prepareStatement(sql).executeQuery();
    }

    public boolean isConnected() {
        return this.pool != null;
    }

}
