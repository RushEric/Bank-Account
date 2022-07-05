# Bank-Account
You have been hired as a programmer by a major bank. Your first project is a small banking transaction system. Each account
consists of a number and a balance. The user of the program (the teller) can create a new account, as well as perform deposits,
withdrawals, and balance inquiries.
Initially, the account information of existing customers is to be read into a pair of parallel arrays--one for account numbers, the
other for balances. The bank can handle up to MAX_NUM accounts. Use the following method to read in the data values:
public static int readAccts(int[] acctNum, double[] balance)

This method fills up the account number and balance arrays by reading from an input file until EOF is reached, and counting
how many accounts are read in. It returns the actual number of accounts read in (later referred to as numAccts).
After initialization, the main program prints the initial database of accounts and balances. Use method printAccts()
described below.
The program then allows the user to select from the following menu of transactions:
Select one of the following:
 W - Withdrawal
 D - Deposit
 N - New account
 B - Balance
 Q – Quit
 X – Delete Account – Extra Credit
