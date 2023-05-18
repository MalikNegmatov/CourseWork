import static java.lang.String.*;

public class Main {
    public static char dash = '-', pipe = '|', plus = '+', blank = ' ';
    public static String line;
    public static Employee[] employeeList = new Employee[12];
    public static void main(String[] args) {

        employeeList[0] = new Employee("ИВ АН", "вАСИЛ ьЁвич", "Комис434cаржевский", 1, 30000);

        for (int i = 1; i < 12; i++) {
            employeeList[i] = new Employee();
        }

        printListFields();
        for (int i = 0; i < 12; i++) {
            printListString(employeeList[i]);
        }
        System.out.println(line);
        System.out.println(employeeList.length);
        System.out.println();
        System.out.println(EmployeeService.getSumAllSalary(employeeList));
        System.out.println(EmployeeService.getSumAllSalary(employeeList,2));
        System.out.println(EmployeeService.getMaxSalary(employeeList));
        System.out.println(EmployeeService.getMinSalary(employeeList,200000));
        System.out.println(EmployeeService.getAverageSalary(employeeList));
        System.out.println(EmployeeService.getAverageDepartmentSalary(employeeList,2));
    }
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
    public static void printListString (Employee employee){
        System.out.printf("| %-3s| %-18s| %-14s| %-15s| %-8s| %-11s|\n", employee.getIdEmployee(),
                employee.getLastName(), employee.getFirstName(), employee.getMiddleName(),
                employee.getDepartment(), employee.getSalary());
    }
}
