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
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *   Class SavingAccount extends Account
 *
 *   Variables:
 *
 *   Constructors:
 *
 *
 *   Methods:
 *
 *              boolean reachBalanceToGainInterest():  pay interest on savings accounts that have high balances, return true if this account has high balance
 *
 *              boolean reachBalanceToPlayStock():   return true if more than $5000 in saving account , otherwise false
 *
 *              void createSecurityAccount():
 *
 *              void transferMoneyToSecurityAccount():
 *
 *              boolean willBeLowBalance(double tryToTransfer):
 *
 *                               return true if there will be less than $2500 in this account after  transfer "tryToTransfer" to security account
 *
 *
 */

public class SavingAccount extends Account{
}
