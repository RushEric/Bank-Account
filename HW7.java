import java.util.Scanner;
import java.io.*;
public class HW7 {
	
	/*
	 * Main method
	 * 
	 * Input: input different character q,b,d,w,n
	 * the value of account Id and balance from initAccts inputfile
	 * 
	 * 
	 * process: switch to different method and default
	 * Q to quit
	 * 
	 * 
	 * Output: print the initAccts value
	 * print the value of different method
	 * print the end of program
	 * 
	 * 
	 * 
	 * */
	public static void main(String[] args) throws IOException {
		
		
			//create a input file which can receive character
			File test = new File("Zicheng's testcase.txt");
			
			// create a input file of initial data base
			File initial = new File("Zicheng's initAccts.txt");
			
			//create a output file
			PrintWriter output = new PrintWriter("Zicheng's HW7 output.txt");
		
			// create scanner for user can type in different character
			Scanner kybd = new Scanner(test);
			
			// create scanner for user can edit initial data base
			Scanner in = new Scanner(initial);
		
			/* initialize the variable num and MAX_NUM,enter,
			judge,account and money*/
			int num,MAX_NUM = 100;
			char enter;
			boolean judge = true;
			int[]account = new int[MAX_NUM];
			double[] money = new double[MAX_NUM];
			
			//set the num to readAccts method could use later
			num = readAccts(account,money,in,output);
			
			//print the start of program
			output.print("Welcome to Zicheng's Banking system\n\n");
			
			//print the initial data base
			printAccts(account,money,num,kybd,output);
		
			// do while looping until user type in Q to quit
			do {
				
				//print the prompt of the menu
				menu();
				System.out.print("Please enter a character");
				
				//receive the input value of testcase and pass the index[0] character
				enter = kybd.next().charAt(0);
			
				//switch to different cases 
				switch(enter) {
			
				/* when the case is Q or q, judge become false
				 * jump out the switch
				 * */
					case 'Q':
					case 'q':
					judge = false;
					break;
				
				/*when the case is N or n, set num to newAcct()
				 * jump out the switch
				 */
					case 'N':
					case 'n':
					num=newAcct(account,money,num,kybd,output);
					break;
			
				/*when the case is W or w, do withdrawal() method
				* jump out the switch
				*/
					case'W':
					case'w':
					withdrawal(account,money,num,kybd,output);
					break;
			
				/*when the case is D or d, do deposit() method
				* jump out the switch
				*/	
					case'D':
					case'd':
					deposit(account,money,num,kybd,output);
					break;
				
				/*when the case is B or b, do balance() method
				* jump out the switch
				*/
					case'B':
					case'b':
					balance(account,money,num,kybd,output);
					break;
					
				/*when the case is X or x, set num to deleteAcct() method
				* jump out the switch
				*/
					case'X':
					case'x':
					num=deleteAcct(account,money,num,kybd,output);
					break;
				
				/*If user enter a character doesn't match any case above
				 * print a error message
				 * jump out the switch
				 * */
					default:
					output.print("\n\n\n\nInvalid character: "+ enter+
					" \nPlease Try again");
					break;
				};
			}
			
			//while judge is true, running the loop
			while(judge);
		
			//print the end of the program
			output.print("\n\n\n\nYou entered Q(exit), Quit banking system.\n"
			+ "\nExtra Credit 2 selected\n\n\n");
			
			//print the final initial data base
			printAccts(account,money,num,kybd,output);
			
			//close kybd scanner
			kybd.close();
			
			//close output scanner
			output.close();
	}
	
	
	/*
	 * menu() method
	 * 
	 * input: null
	 * 
	 * 
	 * process: null
	 * 
	 * 
	 * Output: print the prompt of selection
	 *
	 * 
	 * 
	 * */
	public static void menu(){
		
			//print the prompt of selection
			System.out.print("\n\n W - Withdrawal\n"
				+ " D - Deposit\n"
				+ " N - New account\n"
				+ " B - Balance\n"
				+ " Q – Quit\n"
				+ ""); 
	}
	

	/*
	 * readAccts(int[] acctNum,double[] balance, 
			Scanner kybd, PrintWriter output)method
	 * 
	 * input: value of numAccts, balance from initial data base
	 * 
	 * 
	 * process: read in the value of numAccts, 
	 * balance from initial data base
	 * 
	 * assign each pair of account and balance to the index
	 * 
	 * 
	 * Output: readAccts()
	 *
	 * 
	 * */
	
	public static int readAccts(int[] acctNum,double[] balance, 
			Scanner kybd, PrintWriter output){
		
			//initialize the variable size,turns
			int size = acctNum.length,turns = 0;                		

			//while loop if there is another pair of account and balance
			while (kybd.hasNext() && turns<size){
				
				// assign the value to acctNum and balance from initial data base
				acctNum[turns] = kybd.nextInt();
				balance[turns] = kybd.nextDouble();
				
				// turns increase by 1
				turns++;
			}
			
			// return the value of turns
			return turns;	
	}
	
	/*
	 * findAccts(int[] acctNum, int numAccts, int account) method
	 * 
	 * input: value of numAccts, numAccts and account
	 * 
	 * 
	 * process: if find account in initial data base 
	 * return the index of that account 
	 * else then return to -1
	 * 
	 * 
	 * Output: findAcct()
	 *
	 * 
	 * 
	 * */
	public static int findAcct(int[] acctNum, int numAccts, int account){
			
		// initialize the variable got_it
			int got_it = 0;
			
				//check the whole list of the initial data base
				for(int check = 0; check < numAccts; check++) {
					
					// if find the account
					if (account == acctNum[check]) {
						
						//index of the account would assign to got_it
						got_it = check;
						
						//once find that account, break from there
						break;
					}
					
					// else got_it will become -1
					else {
						got_it = -1;
					}
			}
					//return got_it
					return got_it;
	}
	
	/*
	 * withdrawal(int[] acctNum, double[] balance, int numAccts,
	 *		Scanner kybd, PrintWriter output) method
	 * 
	 * input: value of numAccts,acctNum,balance
	 * 
	 * 
	 * process: withdraw the money from account
	 * print error message if invalid account
	 * and Insufficient Funds
	 * 
	 * 
	 * Output: final receipt or error message 
	 *
	 * 
	 * 
	 * */
	
	public static void withdrawal(int[] acctNum, double[] balance, int numAccts,
			Scanner kybd, PrintWriter output){
			
			// initialize the variable userId, valid, withdrawal
			int userId, valid;
			double withdrawal;
			
			//receive the value of account and assign to userId
			userId = kybd.nextInt();
			
			// assign findAcct() to valid
			valid = findAcct(acctNum,numAccts,userId);
			
			// if valid is -1, account doesn't find and print error message
			if(valid == -1) {
				output.print("\n\n\n\nTransaction Failed: Withdraw"+
				"\nAccount No."+ userId+
				"\nError: Account not found");
			}
			
			//valid is not -1
			else {
				
				//user would enter another value which is withdraw
				withdrawal = kybd.nextDouble();
				
				// if the amount is sufficient
				if(withdrawal > 0 && withdrawal <= balance[valid]) {
					
					// the original amount would minus the withdraw amount
					balance[valid] = balance[valid] - withdrawal;
					
					//print the complete receipt
					output.print("\n\n\n\nTransaction Type: Withdraw"+
					"\nAccount No."+userId+"\nCurrent Balance: $");
					output.printf("%.2f",(balance[valid]+withdrawal));
					output.print("\nAmount to withdraw: $"+ withdrawal+ "\nNew Balance: $");
					output.printf("%.2f",balance[valid]);
				}
				
				//if the withdraw is insufficient
				else {
					if(withdrawal > balance[valid]) {
						//print the error message
						output.print("\n\n\n\nTransaction Failed: Withdraw"
						+ "\nAccount No."+ userId+"\nCurrent Balance: $");
						output.printf("%.2f",balance[valid]);
						output.print("\nAmount to withdraw: $");
						output.printf("%.2f",withdrawal);
						output.print("\nError: Insufficient Funds Available");}
					
					if(withdrawal < 0) {
						output.print("\n\n\n\nTransaction Failed: Withdraw"
						+ "\nAccount No."+ userId+"\nCurrent Balance: $");
						output.printf("%.2f",balance[valid]);
						output.print("\nAmount to withdraw: $");
						output.printf("%.2f",withdrawal);
						output.print("\nError: Amount less than 0");
					}
				}
			}
}
	
	/*
	 * deposit(int[] acctNum, double[] balance, int numAccts, 
				Scanner kybd,PrintWriter output) method
	 * 
	 * input: account id
	 * 
	 * 
	 * process: if find account id prompt user to deposit 
	 *if didn't find account id, print error message
	 * if the amount is equal to or less than zero, print error message
	 * 
	 * 
	 * Output: print the final receipt 
	 *
	 * 
	 * 
	 * */
	
	public static void deposit(int[] acctNum, double[] balance, int numAccts, 
				Scanner kybd,PrintWriter output) {

			// initialize the valid, id,deposit
			int valid, id;
			double deposit;
			
			//receive the account id from testcase
			id = kybd.nextInt();
			
			//set valid to findAcct(acctNum,numAccts,id)
			valid = findAcct(acctNum,numAccts,id);
			
			//if account doesn't find, print error message
			if (valid == -1) {
				output.print("\n\n\n\nTransaction Failed: Deposit"
				+ "\nAccount No."+ id+
				"\nError: Account not found ");
			}
			
			//else do further instruction
			else {
				
				// receive the deposit amount from testcase file
				deposit = kybd.nextDouble();
				
				// if deposit amount greater than 0 print the receipt
				if(deposit>0) {
					balance[valid] = balance[valid] + deposit;
					output.print("\n\n\n\nTransaction Type: Deposit"+
					"\nAccount No."+id+"\nCurrent Balance: $");
					output.printf("%.2f",(balance[valid] - deposit));
					output.print("\nAmount to Deposit: $");
					output.printf("%.2f",deposit); 
					output.print("\nNew Balance: $");
					output.printf("%.2f",balance[valid]);
				}
				
				//else print error message
				else {
					output.print("\n\n\n\nTransaction Failed: Deposit"
					+ "\nAccount No."+id+"\nCurrent Balance: $");
					output.printf("%.2f",balance[valid]);
					output.print("\nAmount to deposit: $ ");
					output.printf("%.2f",deposit);
					output.print("\nError: Amount equal to or less than zero");
				}
			}
	}
	
	/*
	 * newAcct(int[] acctNum, double[] balance, int numAccts,
	 *		Scanner kybd,PrintWriter output) method
	 * 
	 * input: acctNum, balance,numAccts
	 * 
	 * 
	 * process: create a new account, 
	 * verify if the account already exist
	 * 
	 * 
	 * Output: print the final receipt or error message
	 *
	 * 
	 * 
	 * */
	
	public static int newAcct(int[] acctNum, double[] balance, int numAccts,
			Scanner kybd,PrintWriter output){
	
		// initialize newId, valid, anotherNewAccount
		int newId,valid, anotherNewAccount;
		
		// receive the value of account from testcase
		newId = kybd.nextInt();
		
		//assign findAcct() to valid
		valid = findAcct(acctNum,numAccts,newId);
		
		//if account exist print out the error message
		if( valid !=-1){
			output.print("\n\n\n\nTransaction: New Account"
					+"\nAccount No."+newId
					+ "\nError: Account already exists");
			
			//assign numAccts to anotherNewAccount, no changes
			anotherNewAccount = numAccts;
		}
		
		// find out account does not exist
		else {
			
			//assign numAccts to anotherNewAccount
			anotherNewAccount = numAccts;
			
			//newId would become the new last acctNum
			acctNum[anotherNewAccount] = newId;
			
			//value 0.00 assign to new account
			balance[anotherNewAccount] = 0;
			
			//print the receipt
			output.print("\n\n\n\nTransaction Type: New Account");
			output.print("\nAccount N0."+newId);
			output.print("\nCurrent Balance: $0.00");
			anotherNewAccount++;
		}
		return anotherNewAccount;
}

	/*
	 * balance(int[] acctNum, double[] balance, int numAccts,
			Scanner kybd, PrintWriter output) method
	 * 
	 * input: acctNum, balance,numAccts
	 * 
	 * 
	 * process: check the balance if account exists
	 * 
	 * 
	 * Output: print the final receipt or error message
	 *
	 * 
	 * 
	 * */
	public static void balance(int[] acctNum, double[] balance, int numAccts,
			Scanner kybd, PrintWriter output) {
		
			//initialize userId, count
			int userId,count;
			
			//receive the value of account from testcase
			userId = kybd.nextInt();
			
			//assign findAcct() to count
			count = findAcct(acctNum,numAccts,userId);
			
			//if count == -1, the account doesn't exist and print error message
			if(count == -1) {
				output.print("\n\n\n\nTransaction Failed: Balance"+
				"\nAccount No."+ userId+"\nError: Account not found");
			}
			
			// print check balance receipt 
			else {
				output.print("\n\n\n\nTransaction Type: Balance");
				output.print("\nAccount No."+acctNum[count]
						+"\nBalance: $");
				output.printf("%.2f",balance[count]);
			}
}
	/*
	 * printAccts(int[] acctNum, double[] balance, 
			int numAccts,Scanner kybd,PrintWriter output) method
	 * 
	 * input: value of acctNum and balance
	 * 
	 * 
	 * process: for loop each pair of account and balance
	 * 
	 * 
	 * Output: print the table of account and balance
	 *
	 * 
	 * 
	 * */
	
	public static void printAccts(int[] acctNum, double[] balance, 
			int numAccts,Scanner kybd,PrintWriter output){
		
			// print the prompt of table
			output.println("");
			output.printf("%14s","Account Id");
			output.printf("%16s","Balance");
			output.println("\n");
			
			//for loop the each of output of account and balance
			for(int a = 0; a< numAccts; a++) {
				output.printf("%10s",acctNum[a]);
				output.printf("%20.2f\n",balance[a]);
			}
	}
	
	/*
	 * deleteAcct(int[] acctNum, double[] balance, int numAccts,
	 *			Scanner kybd,PrintWriter output)  method
	 * 
	 * input: value of acctNum, numAccts and balance 
	 * 
	 * 
	 * process: delete account if account exist and has no balance
	 * 
	 * 
	 * Output: print the receipt or error message
	 *
	 * 
	 * 
	 * */
	
	public static int deleteAcct(int[] acctNum, double[] balance, int numAccts,
				Scanner kybd,PrintWriter output) {
		
				//initialize deleteId, check
				int deleteId, check;
				deleteId = kybd.nextInt();
				
				//assign findAcct to check
				check = findAcct(acctNum, numAccts,deleteId);
			
				// check if the account exist in the data base
				if(check == -1) {
					output.print("\n\n\n\nTransaction Failed: Delete Account"+
					"\nAccount No."+ deleteId +
					"\nError: Account not found");
					// check stay the same as numAccts
					check = numAccts;
				}
				
				//if findAccts() find the account
				else {
					
					//check if there's balance within the account 
					if(balance[check] == 0.00) {
						output.print("\n\n\n\nTransaction Type: Delete Account"+
						"\nAccount No."+deleteId+
						"\nCurrent Balance: $0.00"+
						"\nAccount No."+deleteId+" just deleted.");
						
						// assign the next index of account and balance
						// to the delete index
						for(int a = 1; a < numAccts-check;a++) {
							acctNum[check+a-1]=acctNum[check+a];
							balance[check+a-1]=balance[check+a];
					}
					
					//check would become to numAccts-1 since we delete an account
					check = numAccts-1;
				}
					
					//there's still balance within the account, couldn't delete
					// print an error message
					else {
						output.print("\n\n\n\nTransaction Failed: Delete Account"+
						"\nAccount No."+ deleteId +
						"\nError: Available funds $");
						output.printf("%.2f",balance[check]);
						output.print(" in account, Withdraw all funds and try again");
						
						//numAccts reamins the same
						check = numAccts;
					}
				}
		return check;
	}
}