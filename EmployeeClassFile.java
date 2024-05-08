package hello;

public class EmployeeClassFile {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Susan Meyers",47899 ,"Accounting","Vice President" );
        Employee employee2 = new Employee("Mark Jones", 39119, "IT", "Programmer" );
        Employee employee3 = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer");

        System.out.println("Name\t\tIDnumber\tDepartment\tPosition");
        System.out.println(employee1.getName() + " " + employee1.getIdnumber() + " " + employee1.getDepartment() +
                "    " + employee1.getPosition() );
        System.out.println(employee2.getName() + "   " + employee2.getIdnumber() + " " + employee2.getDepartment() +
                "            " + employee2.getPosition() );
        System.out.println(employee3.getName() + "   " + employee3.getIdnumber() + " " + employee3.getDepartment() + " " +
                employee3.getPosition() );

    }
}
