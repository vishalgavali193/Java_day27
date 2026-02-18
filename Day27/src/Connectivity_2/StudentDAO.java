package Connectivity_2;

import java.sql.*;

public class StudentDAO {

    PreparedStatement pst;
    ResultSet rs;

    // INSERT
    void store(Student st) {

        String qry = "INSERT INTO students(name, salary) VALUES (?, ?)";

        try {
            pst = DBUtil.getCon().prepareStatement(qry);

            pst.setString(1, st.getName());
            pst.setFloat(2, st.getSalary());

            pst.executeUpdate();

            System.out.println("✅ Student Inserted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    void update(float salary, int id) {

        String qry = "UPDATE students SET salary = ? WHERE id = ?";

        try {
            pst = DBUtil.getCon().prepareStatement(qry);

            pst.setFloat(1, salary);
            pst.setInt(2, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Student Updated!");
            else
                System.out.println("❌ Student Not Found!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    void delete(int id) {

        String qry = "DELETE FROM students WHERE id = ?";

        try {
            pst = DBUtil.getCon().prepareStatement(qry);

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Student Deleted!");
            else
                System.out.println("❌ Student Not Found!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // RETRIEVE ALL
    void retrieveAll() {

        String qry = "SELECT * FROM students";

        try {
            pst = DBUtil.getCon().prepareStatement(qry);

            rs = pst.executeQuery();

            System.out.println("ID\tNAME\tSALARY");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getFloat("salary")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
