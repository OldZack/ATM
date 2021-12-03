/**
 *   Predefined Abstract Class Account
 *
 *   Variables:
 *
 *   Constructors:
 *
 *
 *   Methods:
 *              abstract void makeDeposit(): maintain deposits in at least three different currencies
 *
 *              abstract void withdrawal(): withdraw money from the account
 *
 *              abstract boolean requestAloan(): request loan, return true if request get approved, otherwise false
 *
 *              abstract void takeOutLoans(): take out loans (if they have collateral)
 *
 *              abstract void payBackLoans(): pay the loans on this account
 *
 *              abstract void viewTransactions():
 *
 *              abstract void viewCurrentBalance():
 *
 *              double calculateInterest( double interestRate, double duration, double baseAmountMoney):
 *
 *              void beingCharged(int fee):  being charged a fee
 *
 *                                                    1.every time an account is opened or closed
 *                                                    2.every time a checking account transaction is made
 *                                                    3.every time any withdrawal is made
 * ---------------------------------------------------------------------------------------------------------------------
 *   Class SecurityAccount extends Account
 *
 *   Variables:
 *
 *   Constructors:
 *
 *
 *   Methods:
 *
 *              void enterTrades():
 *
 *              void buyStock():
 *
 *              void sellStock():
 *
 *              void printOpenStocks():
 *
 *              void displayProfit():
 *
 *
 */
public class SecurityAccount extends Account {
}
