import java.util.Arrays;
public class BaseCourse {

    public static void testBaseCourseCondition() {
        /* В данном классе проверяются выполнения условий
           курсовой работы в базовом варианте.
           Условия 1-7 реализованы в классе Employee
           Условия 8 реализованы в классе EmployeeService
         */

        // Проверка создания объекта класса Employee конструктором через данные-параметры
        Main.employeeList[0] = new Employee("ИВ АН", "вАСИЛ ьЁвич", "Комис434cаржевский", 1, 30000);
        // Проверка работы метода toString
        System.out.println(Main.employeeList[0]);
        // Проверка работы сеттеров и геттеров
        Main.employeeList[0].setDepartment(6);
        System.out.println(Main.employeeList[0].getDepartment());
        Main.employeeList[0].setDepartment(5);
        System.out.println(Main.employeeList[0].getDepartment());
        Main.employeeList[0].setSalary(102938);
        System.out.println(Main.employeeList[0].getSalary());
        System.out.println(Main.employeeList[0].getIdEmployee() + " " + Main.employeeList[0].getLastName() + " " +
                Main.employeeList[0].getFirstName() + " " + Main.employeeList[0].getMiddleName());

        // Генерация случайного списка сотрудников конструктором-генератором
        for (int i = 1; i < Main.employeeList.length; i++) {
            Main.employeeList[i] = new Employee();
        }

        // Проверка выполнения условий 8
        EmployeeService.printList(Main.employeeList); // a)
        EmployeeService.printAllSalary(Main.employeeList); // b)
        EmployeeService.printMinSalary(Main.employeeList); // c)
        EmployeeService.printMaxSalary(Main.employeeList); // d)
        EmployeeService.printAverageSalary(Main.employeeList); // e)
        System.out.println();
        // Условие f) - выводим список ФИО сотрудников (сортируем по фамилии)
        Arrays.sort(Main.employeeList, java.util.Comparator.comparing(Employee::getLastName));

        EmployeeService.printSortedAllNameList(Main.employeeList);
        System.out.println(EmployeeService.getAverageDepartmentSalary(Main.employeeList,3));
    }
}
