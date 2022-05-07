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
        indexSalary(employee);
        listEmployees(employee);
        minSalaryEmployeeDepartment(employee, 4);
        maxSalaryEmployeeDepartment(employee, 4);
        sumSalaryDepartment(employee, 4);
        averageSalaryDepartment(employee, 4);
        indexSalaryDepartment(employee, 4, 0.01);
        printEmployeeDepartment(employee, 4);
        compareSalary(employee, 40_000);


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
    }

    static void indexSalary(Employee[] employee) {
        double index = 0.09;
        for (int i = 0; i < employee.length; i++) {
            employee[i].setSalary((int) (employee[i].getSalary() * (1 + index)));
        }
    }

    static void minSalaryEmployeeDepartment(Employee[] employee, int department) {
        int minDepartmentSalary = Integer.MAX_VALUE;
        String minSalaryEmployee = " ";
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < minDepartmentSalary && employee[i].getDepartment() == department) {
                minDepartmentSalary = employee[i].getSalary();
                minSalaryEmployee = employee[i].getFullName();
            }
        }
        System.out.println("Сотрудник с минимальной заработной платой в отделе №" + department + " - " + minSalaryEmployee);
    }

    static void maxSalaryEmployeeDepartment(Employee[] employee, int department) {
        int maxDepartmentSalary = Integer.MIN_VALUE;
        String maxSalaryEmployee = " ";
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() > maxDepartmentSalary && employee[i].getDepartment() == department) {
                maxDepartmentSalary = employee[i].getSalary();
                maxSalaryEmployee = employee[i].getFullName();
            }
        }
        System.out.println("Сотрудник с максимальной заработной платой в отделе №" + department + " - " + maxSalaryEmployee);
    }

    static void sumSalaryDepartment(Employee[] employee, int department) {
        int sumSalaryDepartment = 0;
        for (int i = 0;i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                sumSalaryDepartment += employee[i].getSalary();
            }
        }
        System.out.println("Суммарная заработная плата в отделе №" + department + " за месяц составит " + sumSalaryDepartment + " рублей");
    }

    static void averageSalaryDepartment(Employee[] employee, int department) {
        int number = 0;
        int sumSalaryDepartment = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                number++;
            }
            if (employee[i].getDepartment() == department) {
                sumSalaryDepartment += employee[i].getSalary();
            }
        }
        double averageSalaryDepartment = (double) (sumSalaryDepartment / number);
        // Хотел сделать красивее: через метод sumSalaryDepartment, но метод void, int не контачит с арифметическими действиями :(
        System.out.println("Средняя заработная плата в отделе №" + department + " составляет " + averageSalaryDepartment + " рублей.");
    }

    static void indexSalaryDepartment(Employee[] employee, int department, double index) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                employee[i].setSalary((int) (employee[i].getSalary() * (1 + index)));
            }
        }
    }

    static void printEmployeeDepartment(Employee[] employee, int department) {
        System.out.println("Сотрудники отдела №" + department + ":");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                System.out.println(employee[i].getFullName() + ", зарплата: " + employee[i].getSalary() + " рублей.");
            }
        }
    }

    static void compareSalary(Employee[] employee, int number) {
        System.out.println();
        System.out.println("Сотрудники с зарплатой меньше " + number + " рублей:");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < number) {
                System.out.println(employee[i].getId() + " " + employee[i].getFullName() + " " + employee[i].getSalary());
            }
        }
        System.out.println();
            System.out.println("Сотрудники с зарплатой больше " + number + " рублей:");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() > number) {
                System.out.println(employee[i].getId() + " " + employee[i].getFullName() + " " + employee[i].getSalary());
            }
        }
    }

}
