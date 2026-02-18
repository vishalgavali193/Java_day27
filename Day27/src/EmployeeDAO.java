import java.sql.*;
//import java.time.LocalDate;

public class EmployeeDAO {

    // INSERT
    public void insertEmp(EmployeeJDBC_Task emp) {

        String sql = "INSERT INTO employee(name, dept, salary, joiningDt) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pst = DBUtil.getCon().prepareStatement(sql)) {

            pst.setString(1, emp.getName());
            pst.setString(2, emp.getDept());
            pst.setDouble(3, emp.getSalary());
            pst.setDate(4, Date.valueOf(emp.getJoiningDt()));

            pst.executeUpdate();
            System.out.println("✅ Employee Inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateEmp(double salary, int id) {

        String sql = "UPDATE employee SET salary=? WHERE id=?";

        try (PreparedStatement pst = DBUtil.getCon().prepareStatement(sql)) {

            pst.setDouble(1, salary);
            pst.setInt(2, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Updated");
            else
                System.out.println("❌ Employee Not Found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteEmp(int id) {

        String sql = "DELETE FROM employee WHERE id=?";

        try (PreparedStatement pst = DBUtil.getCon().prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("✅ Deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // GET ALL
    public void getEmp() {

        String sql = "SELECT * FROM employee";

        try (PreparedStatement pst = DBUtil.getCon().prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("dept") + " | " +
                        rs.getDouble("salary") + " | " +
                        rs.getDate("joiningDt")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // GET BY DEPT
    public void getEmpByDept(String dept) {

        String sql = "SELECT * FROM employee WHERE dept=?";

        try (PreparedStatement pst = DBUtil.getCon().prepareStatement(sql)) {

            pst.setString(1, dept);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("salary")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // MAX SALARY
    public void getMaxSal() {

        String sql = "SELECT MAX(salary) FROM employee";

        try (PreparedStatement pst = DBUtil.getCon().prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                System.out.println("💰 Max Salary: " + rs.getDouble(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // AVG SALARY
    public void getAvgSal() {

        String sql = "SELECT AVG(salary) FROM employee";

        try (PreparedStatement pst = DBUtil.getCon().prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                System.out.println("📊 Avg Salary: " + rs.getDouble(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
