import static java.lang.String.valueOf;

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

    public static char dash = '-', pipe = '|', plus = '+', blank = ' ';
    public static String line;
    public static void printListFields () {
        line = plus + valueOf(dash).repeat(4) + plus + valueOf(dash).repeat(19) +
                plus + valueOf(dash).repeat(15) + plus + valueOf(dash).repeat(16) + plus +
                valueOf(dash).repeat(9) + plus + valueOf(dash).repeat(12) + plus;
        System.out.println(line);
        String field = pipe + " id " + pipe + blank +
                "Фамилия" + valueOf(blank).repeat(11) + pipe + blank +
                "Имя" + valueOf(blank).repeat(11) + pipe +  blank +
                "Отчество" + valueOf(blank).repeat(7) + pipe + blank +
                "Отдел" + valueOf(blank).repeat(3) + pipe + blank +
                "Зарплата" + valueOf(blank).repeat(3) + pipe;
        System.out.println(field);
        System.out.println(line);
    }
}
