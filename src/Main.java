public class Main {

    public static Employee[] employeeList = new Employee[12];
    public static void main(String[] args) {

        employeeList[0] = new Employee("ИВ АН", "вАСИЛ ьЁвич", "Комис434cаржевский", 1, 30000);

        for (int i = 1; i < 12; i++) {
            employeeList[i] = new Employee();
        }

        EmployeeService.printListFields();
        for (int i = 0; i < 12; i++) {
            EmployeeService.printListString(employeeList[i]);
        }
        System.out.println(EmployeeService.line);
        System.out.println(employeeList.length);
        System.out.println();
        System.out.println(EmployeeService.getSumAllSalary(employeeList));
        System.out.println(EmployeeService.getSumAllSalary(employeeList,2));
        System.out.println(EmployeeService.getMaxSalary(employeeList));
        System.out.println(EmployeeService.getMinSalary(employeeList,200000));
        System.out.println(EmployeeService.getAverageSalary(employeeList));
        System.out.println(EmployeeService.getAverageDepartmentSalary(employeeList,2));
    }
}
