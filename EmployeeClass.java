package hello;
/* Write a class named Employee that has the following fields:
        - Name: name field references a String object that holds the employee's name.
        - idNumber: idNumber is an int variable that holds the employee's ID number
        - Department: Department field references a String object that holds the name of the department
                      where the employee works
        - Position: Position field references a String object that holds the employee's job title.

    Employee class should have the following constructors:
        - Constructor that accepts the following values as arguments and assigns them to the
          appropriate fields:
            > employee's name
            > employee's ID number
            > department
            > position

        - Constructor that accepts the following values as arguments and assigns them to the
          appropriate fields:
            > employee’s name and ID number. accepted as arguments and assigned fields
            > The department fields assigned an empty string ("")
            > position assigned an empty string ("")

        - no-arg constructor that the:
            > assigns empty strings ("") to name,
            > assigns empty strings ("") to department
            > assigns empty strings ("") to position fields
            > assigns 0 to the idNumber field

   Write appropriate mutator methods that store values in these fields and accessor methods that
   return the values in these fields. Once you have written the class, write a separate program
   that creates three Employee objects to hold the following data:
   Name          | IDnumber |   Department     |  Position
   ====================================================
   Susan Meyers  | 47899    |   Accounting     |  Vice President
   Mark Jones    | 39119    |   IT             |  Programmer
   Joy Rogers    | 81774    |   Manufacturing  |  Engineer
   ====================================================
 */

public class EmployeeClass {
    public static void main(String[] args) {

    }
}
//=======================================================================================================
class Employee{
  //FIELDS
  private String employeeName;//references a String object that holds the employee's name
  private int idNumber;//idNumber is an int variable that holds the employee's ID number
  private String department;//references a String object that holds the name of the department where the employee works
  private String position;//references a String object that holds the employee's job title.
//CONSTRUCTORS
    public Employee(){ //no-arg constructor
        employeeName = " ";//assigns empty strings ("") to name
        department = " ";//assigns empty strings ("") to department
        position = " ";//assigns empty strings ("") to position
        idNumber = 0;//assigns 0 to the idNumber field
    }
  // Constructor that accepts employee's name, employee's ID number, department, position
  // as arguments and assigns them to appropriate fields
    public Employee(String name, int ID, String dep, String pos){
        employeeName = name;
        department = dep;
        position = pos;
        idNumber = ID;
    }
  //Constructor accepts name and ID as arguments, assigns fields to employeeName and idNumber.
  // also assigns empty string value to department and position
    public Employee(String name, int ID){
        employeeName = name;
        idNumber = ID;
        department = " ";
        position = " ";
    }
//METHODS
    //Getter methods
    public String getName()//Getter method returns employee name
    {
        return employeeName;
    }
    public int getIdnumber()//Getter method returns id number
    {
        return idNumber;
    }
    public String getDepartment()//Getter method returns department
    {
        return department;
    }
    public String getPosition()//getter method returns position
    {
        return position;
    }

}
