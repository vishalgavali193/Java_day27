import java.time.LocalDate;
//import java.time.LocalDate;

public class EmployeeJDBC_Task {

    private int id;
    private String name;
    private String dept;
    private double salary;
    private LocalDate joiningDt;

    public EmployeeJDBC_Task(String name, String dept, double salary, LocalDate joiningDt) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.joiningDt = joiningDt;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDept() { return dept; }
    public double getSalary() { return salary; }
    public LocalDate getJoiningDt() { return joiningDt; }
}

