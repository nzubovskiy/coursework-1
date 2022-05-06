package ru.skypro;

public class Main {

    public static void main(String[] args) {
	Employee[] employee = new Employee[10];
        employee[0] = new Employee("Левина Кира Ярославовна", 2, 32_000);
        employee[1] = new Employee("Александрова Виктория Анатольевна", 2, 37_000);
        employee[2] = new Employee("Громов Тимур Максимович", 1, 37_000);
        employee[3] = new Employee("Кравцова Мария Захаровна", 4, 34_000);
        employee[4] = new Employee("Андреев Даниил Даниилович", 1, 34_000);
        employee[5] = new Employee("Капустин Тимофей Константинович", 3, 38_000);
        employee[6] = new Employee("Петров Александр Маркович", 4, 33_000);
        employee[7] = new Employee("Олейникова Марта Кирилловна", 5, 35_000);
        employee[8] = new Employee("Попов Максим Максимович", 5, 36_000);
        employee[9] = new Employee("Боброва Анна Михайловна", 2, 36_000);

        listEmployees(employee);
        sumSalary(employee);
        minSalaryEmployee(employee);
        maxSalaryEmployee(employee);
        averageSalary(employee);
        getEmployeeFullName(employee);


    }

    public static void listEmployees(Employee[] employee) {
        for (int i = 0; i < 10; i++) {
            System.out.println(employee[i]);
        }
    }

    static int sumSalary(Employee[] employee) {
        int sumSalary = 0;
        for (int i = 0;i < employee.length; i++) {
            sumSalary += employee[i].getSalary();
        }
        System.out.println("Суммарная заработная плата за месяц составит " + sumSalary + " рублей");
        return sumSalary;
    }

    static String minSalaryEmployee(Employee[] employee) {
        int min = Integer.MAX_VALUE;
        String minSalaryEmployee = " ";
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < min) {
                min = employee[i].getSalary();
                minSalaryEmployee = employee[i].getFullName();
            }
        }
        System.out.println("Сотрудник с наименьшей заработной платой - " + minSalaryEmployee);
        return minSalaryEmployee;
    }

    static String maxSalaryEmployee(Employee[] employee) {
        int max = Integer.MIN_VALUE;
        String maxSalaryEmployee = " ";
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() > max) {
                max = employee[i].getSalary();
                maxSalaryEmployee = employee[i].getFullName();
            }
        }
        System.out.println("Сотрудник с наибольшей заработной платой - " + maxSalaryEmployee);
        return maxSalaryEmployee;
    }

    static double averageSalary(Employee[] employee) {
        int length = employee.length;
        double averageSalary = (double) (sumSalary(employee) / length);
        System.out.println("Средняя заработная плата составит " + averageSalary + " рублей.");
        return averageSalary;
    }

    static void getEmployeeFullName(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i].getFullName());
        }
            ;

    }
}
