package config;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
public class DatabaseConnectionPool {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;
    static {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/inventario_db");
        config.setUsername("root");
        config.setPassword("password");
        config.setMaximumPoolSize(10);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void closePool() {
        if (ds != null) {
            ds.close();
        }
    }
}
