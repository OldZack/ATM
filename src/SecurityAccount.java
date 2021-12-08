/**
 *   Abstract Class Account
 *
 *   Variables:
 *
 *              enum ActionType:
 *                                  DEPOSIT, WITHDRAW,  TRANSFEROUT,TRANSFERIN,REQUESTLOAN,TAKEOUTLOAN,  PAYBACKLOAN, INTEREST,SERVICEFEE
 *
 *              String accountId:
 *
 *              Map<CurrencyType,Deposit> currenciesDeposit:
 *
 *              Map<CurrencyType,Loan>     loans:
 *
 *              ArrayList<String>  transactions:  date ,currencyType, before, action type, transaction amount, after
 *
 *              double depositInterestRate:
 *
 *              double loanInterestRate:
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
 *              void transferTo( ): transfer money
 *
 *              void getTransferFrom(CurrencyType cType, double transAmount)
 *      Loan:
 *              abstract boolean requestLoan(): request loan, return true if request get approved, otherwise false
 *
 *              abstract void takeOutLoan(): take out loans (if they have collateral)
 *
 *              abstract void payBackLoan(): pay the loans on this account
 *
 *      DisplayInfo:
 *
 *              abstract void viewTransactions():
 *
 *              abstract void viewCurrentBalance():
 *
 *      Helpers:
 *
 *              void writeToTransactionsLog(CurrencyType cType,ActionType AType, double transAmount):
 *
 *              double calculateInterest( double interestRate, int durationDays, double baseAmountMoney):
 *
 *              void beingCharged(CurrencyType cType ,double fee):  being charged a fee
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
