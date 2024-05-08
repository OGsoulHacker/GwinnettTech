package hello;
import java.util.Scanner;
/* Write a Payroll class that uses the following array fields
        - employeeid : array of 7 integers to hold employee id numbers
            > 5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489
        - hours: Array of 7 integers to hold the number of hours worked by each employee.
        - payrate: Array of seven doubles to hold each employee's hourly pay rate
        - wages: Array of seven doubles to hold each employee's gross pay
    The class should relate the data in each array through subscripts.
        Example:
            > the number of element 0 of the hours should be the number of hours worked by the
            employee whose ID number is stored in element 0 of the employeeId array. That same employee's
            pay rate should be stored in element 0 of the payRate array.
    in addition to the appropriate accessor and mutator methods, the class should have a method that accepts
    an employee's ID number as an argument and returns the gross pay for that employee

    Demonstrate the class in a complete program that displays each employee number and asks the user
    to enter that employeee's ID number and gross wages

    Input validation: Do not accept negative values for hours or numbers less than 6.00 for pay rate.
 */
public class PayrollClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);// Making scanner object
        PayRoll payroll = new PayRoll();//Making payroll object
        int[] employeeIds = new int[]{56588, 45201, 78951, 87775, 84512, 13028, 75804};
        payroll.setEmployseidArray(employeeIds);

        for (int i = 0; i < payroll.getEmployseIDArray().length; i++) {
            System.out.println("Enter the number of hours for employee "+(i+1));
            payroll.setHours(i, input.nextInt());// reading the value for ith employee's number of hours using 'Scanner' object 'input'
            System.out.println("Enter the pay rate for employee "+(i+1));
            payroll.setPayRate(i, input.nextDouble()); // reading the value for ith employee's pay rate using 'Scanner' object 'input'
        }

        payroll.calculateWagesArray();//calculating 'Wages' for each employee
        // using getter function for each array to get the 'private' arrays
        int employseid[] = payroll.getEmployseIDArray();
        int hours[] = payroll.getHoursArray();
        double payRate[] = payroll.getPayRateArray();
        double wages[] = payroll.getWagesArray();

        System.out.println("employeeID\thours\tpayRate\twages");// displaying the report output
        for(int i = 0;i < payroll.arrayLength; i++)
            System.out.println(employseid[i]+"\t\t"+hours[i]+"\t"+payRate[i]+"\t"+wages[i]);
        //closing the scanner object 'input'
        input.close();
    }
}
//=====================================================================================================
class PayRoll {
    static final int arrayLength = 7;//Declares static and constant ('Final') variable 'arrayLength' to store length of the array
    private int employseid[];//Declaring employee ID array
    private int hours[];//Declaring hours array
    private double payRate[];//Declaring payRate array
    private double wages[];//Declaring wages array
    PayRoll()// 'Payroll' constructor to initialize 'employseid' and define the size of other arrays
    {
        this.employseid = new int[arrayLength];
        this.hours = new int[arrayLength];
        this.payRate = new double[arrayLength];
        this.wages = new double[arrayLength];
    }
    void setEmployseidArray(int[] employeeIds)
    {
        this.employseid = employeeIds;
    }

    int[] getEmployseIDArray()//'getEmployseIDArray' - a getter function to return the 'employseid' array
    {
        return this.employseid;
    }
    //'setHours' used as setter function to set hours
    void setHours(int index, int numOfHours)
    {
        this.hours[index] = numOfHours;
    }
    int[] getHoursArray()// 'getHoursArray' a getter function to return the 'hours' array as the output
    {
        return this.hours;
    }
    // 'setPayRate' used as setter function to set the pay rate for each employee
    void setPayRate(int index, double payRate)
    {
        this.payRate[index] = payRate;
    }
    // 'getPayRateArray' a getter function to return the 'payRate' array as the output
    double[] getPayRateArray()
    {
        return this.payRate;
    }

    // 'findIndex' - function
    // takes the employeeID 'empID' as input (parameter)
    // return the index of array 'employseid' at which 'empID' is present
    // if 'empID' is not present then -1 is returned
    int findIndex(int empID)
    {
        for(int i = 0; i < arrayLength; i++)
        {
            if(this.employseid[i] == empID)
                return i;
        }
        return -1;
    }
    // 'getWages' - function as required in the problem
    // employeeID is passed as input (parameter)
    // first array index of employee with the emplyeeID is found using 'findIndex' function
    // then 'grossPay' is calculated by multiplying 'hours' with 'payRate' for the 'empIndex'
    // finally 'grossPay' is round off to 2 decimal places and returned
    double getWages(int employeeID)
    {
        int empIndex = findIndex(employeeID);
        double grossPay = this.hours[empIndex] * this.payRate[empIndex];
        grossPay = (Math.round(grossPay * 100.00)) / 100.00; // rounding off to 2 decimal places
        return grossPay;
    }
    // 'calculateWagesArray' - function to compute the array 'wages'
    // 'getWages' function is used on each 'employseid' element
    void calculateWagesArray()
    {
        for (int i = 0; i < arrayLength; i++)
        {
            this.wages[i] = this.getWages(this.employseid[i]);
        }
    }
    // 'getWagesArray' - getter function to return wages array
    double[] getWagesArray()
    {
        return this.wages;
    }
}