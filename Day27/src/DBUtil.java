import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {

    private static Connection con;

    public static Connection getCon() {

        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/companydb",
                        "root",
                        "Vishal@2004"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
