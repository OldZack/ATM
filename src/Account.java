import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *   Abstract Class Account
 *
 *   Variables:
 *
 *              enum ActionType:
 *                                  DEPOSIT, WITHDRAW, TAKEOUTLOAN,  PAYBACKLOAN, INTEREST
 *
 *              char accountId:
 *
 *              Map<CurrencyType,Deposit> currenciesDeposit:
 *
 *              ArrayList<Loan>     loans:
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
 *              double calculateInterest( double interestRate, double duration, double baseAmountMoney):
 *
 *              void beingCharged(int fee):  being charged a fee
 *
 *                                                    1.every time an account is opened or closed
 *                                                    2.every time a checking account transaction is made
 *                                                    3.every time any withdrawal is made
 * ---------------------------------------------------------------------------------------------------------------------
 *
 */



public abstract class Account {
    protected enum ActionType{
        DEPOSIT,WITHDRAW,TAKEOUTLOAN,PAYBACKLOAN, INTEREST
    }
    protected char accountId;
    protected Map<CurrencyType,Deposit> currenciesDeposit;
    protected Map<CurrencyType,Loan>  loans;
    protected ArrayList<String>  transactions;
    protected double depositInterestRate;
    protected double loanInterestRate;

    public Account(){
        this.currenciesDeposit=new HashMap<CurrencyType,Deposit>();
        this.loans= new HashMap<CurrencyType,Loan>();
        this.transactions= new ArrayList<String >();
    }

    public double calculateInterest( double interestRate, double duration, double baseAmountMoney){
        return interestRate * duration * baseAmountMoney;
    }

    public void writeToTransactionsLog(CurrencyType cType,ActionType AType, double transAmount)

    {   double before,after;
        // Loan
        if(AType ==ActionType.PAYBACKLOAN || AType ==ActionType.TAKEOUTLOAN)
        {
            before = loans.get(cType).getAmount();
             after = before + transAmount; // +/- positive or negative
        }
        // Deposit
        else {
             before = currenciesDeposit.get(cType).getAmount();
             after = before + transAmount; // +/- positive or negative
        }
       this.transactions.add( (new Date()).toString() + cType.toString() + before+ AType.toString()+ transAmount+ after);
    }

}
