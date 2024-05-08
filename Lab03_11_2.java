package hello;
import java.util.Calendar;
import java.util.Date;
/*The Person, Student, Employee, Faculty, and Staff classes
 > Override the toString method in each class to display the class name and the person's name.
 > Draw the UML diagram for the classes and implement them.
 > Write a test program that creates a Person, Student, Employee, Faculty, and Staff, and invokes their
   toString() methods.
Design a class named Person:
    > A person has a:
        - name
        - address
        - phone number
        - email address
 > Make the following subclasses of the Person class:
     - Student
         > A student has a class status of:
             - freshman : constant
             - sophomore : constant
             - junior : constant
             - senior : constant
     - Employee
        > An employee has an:
            - office
            - salary
            - date hired : Use the MyDate class defined in exercise 10.14 to create an object for date hired
      > Make the following subclasses of the Employee subclass:
        - Faculty
            > A faculty member has:
                - office hours
                - rank
        - Staff
            > A staff member has a:
                - Title
*/
public class Lab03_11_2 {
    public static void main(String[] args) {
        Person person1 = new Person();//creates object from a class for person1
        person1.setName("Kaizu");//Set name is printed out
        System.out.println(person1.toString());//printing out

        Student student1 = new Student();
        student1.setName("Justyn");
        System.out.println(student1.toString());

        Employees employee1 = new Employees();
        employee1.setName("Alex");
        System.out.println(employee1.toString());

        Faculty faculty1 = new Faculty();
        faculty1.setName("Misa");
        System.out.println(faculty1.toString());

        Staff staff1 = new Staff();
        staff1.setName("Liz");
        System.out.println(staff1.toString());
    }
}
class Person{//super (parent class)
    @Override
    public String toString(){
        return "Person: " + this.getName();
    }
    String name; //name property
    String address; //address property
    String number; //number property
    String email; //email property
    public String getName() {//Getter method, returns persons name
        return name;
    }
    public void setName(String name){//setter method passes name parameter
        this.name = name;// assigns name to name
    }
}
class Student extends Person { // Student is a subclass of Person, inherits properties from Person(parent) class
    @Override
    public String toString(){
        return "Student: " + this.getName() ;
    }
//    final static String = "Freshman";
//    final static String = "sophomore";
//    final static String = "Junior";
//    final static String = "senior"; // A student has a class status of: senior.
}
class Employees extends Person {// Employee is a subclass of person
    @Override
    public String toString() {
        return "Employee: " + this.getName();
    }
    String office;
    double salary;
    MyDate dateHired;
    public String office(){
        return office;
    }

    public void setOffice(String office){
        this.office = office;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public MyDate getMyDate(){
        return dateHired;
    }
}
class Faculty extends Employees{//Faculty is a subclass of Employee. Inherits everything from employee class
    @Override
    public String toString(){
        return "Faculty: " + this.getName();
    }
    String officeHours;
    String rank;
}
class Staff extends Employees{//Staff is a subclass of Employee. Inherits everything from employee class
    @Override
    public String toString(){
        return "Staff: " + this.getName();
    }
    String title;
}
    /*Design a class named Mydate

     */
class MyDate {
    Calendar c = Calendar.getInstance();
    private int year, month, day;

    public MyDate() {
        this(System.currentTimeMillis());
    }
    public MyDate(long millis) {
        setDate(millis);
    }
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public void setDate(long millis) {
        c.setTimeInMillis(millis);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
    }
    public void display() {
        System.out.printf("%d/%d/%d (mm/dd/yyyy)\n", month, day, year);
    }
}