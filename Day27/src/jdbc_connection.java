import java.sql.*;

public class jdbc_connection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/dypdb";
        String username = "root";
        String password = "Atharv@sql123";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("✅ Connected Successfully!");

            // 1️⃣ Create Statement
            Statement stmt = con.createStatement();

            // 2️⃣ Execute Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");

            // 3️⃣ Process Result
            while (rs.next()) {
                System.out.println(
                        rs.getInt("emp_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("dept") + " | " +
                        rs.getDouble("salary") + " | " +
                        rs.getString("city") + " | " +
                        rs.getDate("hire_date")
                );
            }

            // 4️⃣ Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
