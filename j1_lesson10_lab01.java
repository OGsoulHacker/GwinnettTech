import java.util.Scanner;
//import Account;
public class j1_lesson10_lab01 {
/*10.7(Game: ATM machine)
 * Use the Account class created in programming exercise 9.7 to simulate an 
 * ATM machine.
 * ------------------------------------------------------------------------
 * > Create 10 accounts in an array with id 0, 1,...9
 * 		- with an initial balance of $100.
 * > System prompts the user to an id
 * 		/-If the id is entered incorrectly, ask user to correct id.
 * 		-Once id is accepted, main menu is displayed
 * > You can enter:
 * 		- 1 for viewing the current balance
 * 		- 2 for withdrawing money
 * 		- 3 for depositing money
 * 		- 4 for exiting the main menu
 * 			-once you exit, system will prompt for an id again
 * ------------------------------------------------------------------------
 */
	
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		int choice = 0;
		double amount;// = input.nextDouble();
		int id;
		//Uses Account class created in exercise 9.7, 
		//new Account [10] Creates array that holds 10 accounts
		Account[] accounts = new Account[10];
//for loop runs 10 times to create id's 0-9 with balance of 100
		//.length length of array
		//i begins at 0
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, 100);
		}


		while (true) {


			System.out.println("Input Correct ID: ");
			id = input.nextInt();

			while (isValidID(id) != true) {
				System.out.println("invalid ID");
				System.out.println("Input Correct ID: ");
				id = input.nextInt();
			}

			Account user = getAccount(accounts, id);
			while (choice != 4) {
				System.out.println("Input 1 to view account balance:");
				System.out.println("Input 2 to withdraw funds:");
				System.out.println("Input 3 to deposit funds:");
				System.out.println("Input 4 to exit the system:");
				choice = input.nextInt();
				switch (choice) {
					case 1:
						System.out.printf("Balance is: %.2f \n", user.getBalance());
						break;
					case 2:
						choice = 2;
						amount = input.nextDouble();
						user.withdraw(amount);
						System.out.printf(" Withdraw amount is: %.2f", amount);

						break;
					case 3:
						amount = input.nextDouble();
						user.deposit(amount);
						System.out.printf("Deposit amount is:  %.2f", amount);

						break;
					case 4:
						System.out.println("Logged out...");
						break;
					default:
						System.out.println("Invalid response");
						break;
				}

			}

		}
	}
	 public static Account getAccount(Account[] accounts, int id) {
		 
//for each loop
	        for (Account account : accounts) {
	        	
	            if (id == account.getId()) {
	            	
	                return account;
	            }
	        }
	        return null;
	   }

	public static boolean isValidID(int id) {
		if  (0 <= id && id <= 9) {
			return true;
		}
		else return false;
	}
	
}


