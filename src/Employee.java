public class Employee {
    private String firstName;   // Имя
    private String middleName;  // Отчество
    private String lastName;    // Фамилия
    private int department;     // отдел
    private int salary;         // зарплата
    public static int id = 1;   // счетчик для присваивания объекту класса уникального id
    private final int idEmployee;     // id сотрудника

    /** методы get и set для всех полей класса */
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getDepartment() {
        return department;
    }
    public int getSalary() {
        return salary;
    }
    public int getIdEmployee() {
        return idEmployee;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Employee(String firstName, String middleName, String lastName, int department, int salary) {
        this.firstName = formatStr(firstName);
        this.middleName = formatStr(middleName);
        this.lastName = formatStr(lastName);
        this.department = department;
        this.salary = salary;
        this.idEmployee = id;
        id++;
    }
    public Employee() {
        java.util.Random random = new java.util.Random();
        String[] names;
        names = generateName();
        this.firstName = names[0];
        this.middleName = names[1];
        this.lastName = names[2];
        this.department = random.nextInt(5) + 1;
        this.salary = random.nextInt(200000) + 40000;
        this.idEmployee = id;
        id++;
    }
    private String[] generateName() {
        java.util.Random random = new java.util.Random();
        String[] names = new String[3];
        int i = random.nextInt(2);
        if ( i == 0 ) {
            names[0] = firstManNames[random.nextInt(21)];
            names[1] = middleManNames[random.nextInt(21)];
            names[2] = lastManNames[random.nextInt(21)];
        }
        else {
            names[0] = firstFemaleNames[random.nextInt(21)];
            names[1] = middleFemaleNames[random.nextInt(21)];
            names[2] = lastFemaleNames[random.nextInt(21)];
        }
        return names;
    }

    public String formatStr(String str) {
        str = checkInputErrors(str);
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    public String checkInputErrors(String str) {
        if (str != null && str.length() > 0) {
            str = str.replaceAll("[^а-яa-zA-zА-ЯЁё]", "");
        }
        return str;
    }
    @Override
    public String toString() {
        return "id " + this.idEmployee + ": " + this.lastName + " " + this.firstName + " " +
                this.middleName + ": отдел №" + this.department + ": зарплата: " + this.salary;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Employee employee = (Employee) other;

        if (department != employee.department) return false;
        if (salary != employee.salary) return false;
        if (idEmployee != employee.idEmployee) return false;
        if (!firstName.equals(employee.firstName)) return false;
        if (!middleName.equals(employee.middleName)) return false;
        return lastName.equals(employee.lastName);
    }
    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + department;
        result = 31 * result + salary;
        result = 31 * result + idEmployee;
        return result;
    }

    /* Можно было бы прикрутить ресурсами текстовых файлов и подгружать. Но мы ещё этого как бы не знаем,
       поэтому списки имен для генерации ФИО реализованы в виде статических массивов внутри класса */
    private final String[] firstManNames = new String[] {"Иван", "Сергей", "Борис", "Павел", "Геннадий", "Алексей", "Александр",
            "Виталий", "Олег", "Василий", "Петр", "Руслан", "Марат", "Владимир", "Дмитрий", "Радион", "Федор",
            "Семен", "Кирилл", "Андрей", "Феликс"};
    private final String[] middleManNames = new String[] {"Иванович", "Сергеевич", "Борисович", "Павлович", "Геннадьевич",
            "Алексеевич", "Александрович", "Витальевич", "Олегович", "Васильевич", "Петрович", "Русланович",
            "Маратович", "Владимирович", "Дмитриевич", "Радионович", "Федорович", "Семенович", "Кириллович",
            "Андреевич", "Константинович"};
    private final String[] lastManNames = new String[] {"Хорошилов", "Сергеев", "Борисов", "Павлов", "Семашко",
            "Васильев", "Родионов", "Прохоров", "Райкунов", "Малышев", "Точилин", "Сгибнев", "Фоминов",
            "Макаров", "Захаренко", "Шевченко", "Маслов", "Курбатов", "Шеин", "Рязанов", "Егоров"};

    private final String[] firstFemaleNames = new String[] {"Светлана", "Алёна", "Вероника", "Татьяна", "Маргарита",
            "Варвара", "Александра", "Прасковья", "Анна", "Елена", "Вера", "Надежда", "Любовь", "Клара",
            "Марина", "Алла", "Ульяна", "Евгения", "Лидия", "Ольга", "Наталья"};
    private final String[] middleFemaleNames = new String[] {"Ивановна", "Сергеевна", "Борисовна", "Павловна",
            "Геннадьевна", "Алексеевна", "Александровна", "Витальевна", "Олеговна", "Васильевна", "Петровна",
            "Руслановна", "Маратовна", "Владимировна", "Дмитриевна", "Радионовна", "Федоровна", "Семеновна",
            "Кирилловна", "Андреевна", "Константиновна"};
    private final String[] lastFemaleNames = new String[] {"Реймер", "Сергеева", "Борисова", "Павлова", "Семашко",
            "Васильева", "Родионова", "Прохорова", "Райкунова", "Малышева", "Точилина", "Сгибнева", "Фоминова",
            "Макарова", "Захаренко", "Шевченко", "Маслова", "Курбатова", "Шеина", "Рязанова", "Егорова"};
}
