/**
<<<<<<< HEAD
 *   Predefined  Abstract Class Account:
=======
 *   Abstract Class Account
>>>>>>> origin/szy
 *
 *   Variables:
 *
 *              enum ActionType:
<<<<<<< HEAD
 *                                  DEPOSIT, WITHDRAW,TRANSFEROUT,TRANSFERIN, REQUESTLOAN, TAKEOUTLOAN,  PAYBACKLOAN, INTEREST, SERVICEFEE
=======
 *                                  DEPOSIT, WITHDRAW, TRANSFEROUT,TRANSFERIN, REQUESTLOAN,TAKEOUTLOAN,  PAYBACKLOAN, INTEREST, SERVICEFEE
>>>>>>> origin/szy
 *
 *              String accountId:
 *
 *              Map<CurrencyType,Deposit> currenciesDeposit:
 *
<<<<<<< HEAD
 *              Map<CurrencyType,Loan>      loans:
=======
 *              ArrayList<Loan>     loans:
>>>>>>> origin/szy
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
<<<<<<< HEAD
 *      Account:
 *              void openAccount():
 *
 *              void closeAccount():
 *
=======
>>>>>>> origin/szy
 *      Deposit:
 *              abstract void makeDeposit(): maintain deposits in at least three different currencies
 *
 *              abstract void withdrawal(): withdraw money from the account
 *
 *              void transferTo( ): transfer money
 *
 *              void getTransferFrom(CurrencyType cType, double transAmount)
<<<<<<< HEAD
 *     Loan:
=======
 *      Loan:
>>>>>>> origin/szy
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
 *
 *
 *
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

    //Deposit:
    public void makeDeposit()
    {
        //Ask user type of currency

        //Ask user amount

        //Charge a fee

        //Record above fee charging action into transactions

        //Record Deposit action into transactions

        // Perform actual balance increment at this.currenciesDeposit

    }
    public void withdrawal(){
        //Ask user type of currency

        //Ask user amount

        //Charge a fee

        //Record above fee charging action into transactions

        //Record Deposit action into transactions

        // Perform actual balance decrement at this.currenciesDeposit

    }


    //Loan:
    public boolean requestLoan()
    {
        //Ask user type of currency

        //Ask user amount

        //Charge a fee

        //Record above fee charging action into transactions

        //Record REQUESTLOAN action into transactions

        //Add a new loan to this.loans


        return false;
    }
    public void takeOutLoan()
    {

        //Ask user amount

        //Charge a fee

        //Record above fee charging action into transactions

        //Record TAKEOUTLOAN action into transactions

        //Perform actual balance increment at this.currenciesDeposit

        // set hadBeenWithdrawn to true
    }
    public void payBackLoan()
    {
        //Ask user which loan

        //Charge a fee

        //Record above fee charging action into transactions

        //Update the loan amount , plus the interest

        //Record above INTEREST adding action into transactions

        //Record PAYBACKLOAN action into transactions

        //Perform actual balance decrement at this.currenciesDeposit

        //remove the loan from this.loans

    }


    //DisplayInfo:


}
