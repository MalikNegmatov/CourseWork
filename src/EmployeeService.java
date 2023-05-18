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
    public static char dash = '-', pipe = '|', plus = '+', blank = ' ';
    public static void printLine() {
        String line = plus + valueOf(dash).repeat(4) + plus + valueOf(dash).repeat(19) +
                plus + valueOf(dash).repeat(15) + plus + valueOf(dash).repeat(16) + plus +
                valueOf(dash).repeat(9) + plus + valueOf(dash).repeat(12) + plus;
        System.out.println(line);
    }
    public static void printListFields () {
        printLine();
        fieldTable();
        printLine();
    }

    private static void fieldTable() {
        String field = pipe + " id " + pipe + blank +
                "Фамилия" + valueOf(blank).repeat(11) + pipe + blank +
                "Имя" + valueOf(blank).repeat(11) + pipe +  blank +
                "Отчество" + valueOf(blank).repeat(7) + pipe + blank +
                "Отдел" + valueOf(blank).repeat(3) + pipe + blank +
                "Зарплата" + valueOf(blank).repeat(3) + pipe;
        System.out.println(field);
    }
    public static void printList (Employee[] employees) {
        printListFields();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        EmployeeService.printLine();
    }
    private static void fieldNamesTable() {
        String field = pipe + " id " + pipe + blank +
                "Фамилия Имя Отчество" + valueOf(blank).repeat(54) + pipe;
        System.out.println(field);
    }
    public static void printNamesFields () {
        EmployeeService.printLine();
        fieldNamesTable();
        EmployeeService.printLine();
    }

    public static String namesToString(Employee employee) {
        String out = employee.getLastName() + blank + employee.getFirstName() + blank + employee.getMiddleName();
        return String.format("| %-3s| %-74s|", employee.getIdEmployee(), out);
    }
    public static void printSortedAllNameList (Employee[] employees) {
        printNamesFields();
        for (Employee employee : employees) {
            System.out.println(namesToString(employee));
        }
        EmployeeService.printLine();
    }
    public static void printAllSalary (Employee[] employees) {
        String field = "Сумма затрат на зарплаты в месяц";
        System.out.printf("| %-56s| %-21s|\n",field,getSumAllSalary(employees));
        EmployeeService.printLine();
    }
    public static void printMinSalary (Employee[] employees) {
        String field = "Сотрудник с минимальной зарплатой";
        System.out.printf("| %-56s| %-21s|\n",field,getMinSalary(employees,200000));
        EmployeeService.printLine();
    }
    public static void printMaxSalary (Employee[] employees) {
        String field = "Сотрудник с максимальной зарплатой";
        System.out.printf("| %-56s| %-21s|\n",field,getMaxSalary(employees));
        EmployeeService.printLine();
    }
    public static void printAverageSalary (Employee[] employees) {
        String field = "Среднее значение зарплат";
        System.out.printf("| %-56s| %-21s|\n",field,getAverageSalary(employees));
        EmployeeService.printLine();
    }
}
