/**
 *   Predefined Abstract Class Account
 *
 *
 *   Variables:
 *
 *              char accountId:
 *
 *              ArrayList<Currency> currenciesDeposit:
 *
 *              ArrayList<Loan>     loans:
 *
 *   Constructors:
 *
 *
 *   Methods:
 *
 *      Deposit:
 *              abstract void makeDeposit(): maintain deposits in at least three different currencies
 *
 *              abstract void withdrawal(): withdraw money from the account
 *
 *      Loan:
 *              abstract boolean requestAloan(): request loan, return true if request get approved, otherwise false
 *
 *              abstract void takeOutLoans(): take out loans (if they have collateral)
 *
 *              abstract void payBackLoans(): pay the loans on this account
 *
 *      DisplayInfo:
 *
 *              abstract void viewTransactions():
 *
 *              abstract void viewCurrentBalance():
 *
 *      Helpers:
 *
 *              double calculateInterest( double interestRate, double duration, double baseAmountMoney):
 *
 *              void beingCharged(int fee):  being charged a fee
 *
 *                                                    1.every time an account is opened or closed
 *                                                    2.every time a checking account transaction is made
 *                                                    3.every time any withdrawal is made
 * ---------------------------------------------------------------------------------------------------------------------
 *   Class CheckingAccount extends Account
 *
 *   Variables:
 *
 *   Constructors:
 *
 *
 *   Methods:
 *
 *
 *
 *
 *
 */

public class CheckingAccount extends Account {
}
