package hwork9;



import java.util.Collections;
import java.util.List;


public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);
        // Дописать метод employeeGenerator и
        // отсортировать его по:
        // имени
        // имени и зарплате
        // имени, зарплате, возрасту и компании
        Collections.sort(employees, new Employee.nameComparator());
        System.out.println(employees);
        Collections.sort(employees, new Employee.nameComparator().
                thenComparing(new Employee.salaryComparator()));
        System.out.println(employees);
        Collections.sort(employees, new Employee.nameComparator().
                thenComparing(new Employee.salaryComparator()).
                thenComparing(new Employee.ageComparator()).
                thenComparing(new Employee.companyComparator()));
        System.out.println(employees);
    }


}