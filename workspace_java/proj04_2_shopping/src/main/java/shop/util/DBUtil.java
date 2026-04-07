package shop.util;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

    private static DataSource ds;

    static {
        try {
            ds = (DataSource) new InitialContext()
                .lookup("java:/comp/env/jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    }
}