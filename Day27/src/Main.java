import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();

        EmployeeJDBC_Task e1 = new EmployeeJDBC_Task("Vishal", "IT", 75000, LocalDate.of(2023, 1, 10));

        dao.insertEmp(e1);
        dao.getEmp();
        dao.getEmpByDept("IT");
        dao.getMaxSal();
        dao.getAvgSal();
    }
}
