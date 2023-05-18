public class EmployeeService {

    public static double getSumAllSalary(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) sum += employee.getSalary();
        }
        return sum;
    }
    public static double getMaxSalary(Employee[] employees) {
        double maxSalary = 0;
        for (Employee employee : employees) {
            if (employee == null){continue;}
            if (maxSalary < employee.getSalary())
                maxSalary = employee.getSalary();
        }
        return maxSalary;
    }
    public static double getMinSalary(Employee[] employees, int max)
    {
        double minSalary = max;
        for (Employee employee : employees) {
            if (minSalary > employee.getSalary())
                minSalary = employee.getSalary();
        }
        return minSalary;
    }
    public static double getSumAllSalary(Employee[] employees, int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }
    public static int getDepartmentLength(Employee[] employees, int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                count++;
            }
        }
        return count;
    }
    public static double getAverageSalary(Employee[] employees) {
        return getSumAllSalary(employees)/employees.length ;
    }
    public static double getAverageDepartmentSalary(Employee[] employees, int department) {
        return getSumAllSalary(employees, department)/getDepartmentLength(employees, department);
    }
    public static void printListString (Employee employee){
        System.out.printf("| %-3s| %-18s| %-14s| %-15s| %-8s| %-11s|\n", employee.getIdEmployee(),
                employee.getLastName(), employee.getFirstName(), employee.getMiddleName(),
                employee.getDepartment(), employee.getSalary());
    }
}
