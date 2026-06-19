package util;

import java.sql.*;

public class DBUtil {
    public static Connection dbConnect() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.0.40:1521:XE",
                "hr",
                "hr"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}