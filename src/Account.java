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
 *                                  DEPOSIT, WITHDRAW,TRANSFEROUT,TRANSFERIN, REQUESTLOAN, TAKEOUTLOAN,  PAYBACKLOAN, INTEREST, SERVICEFEE
 *
 *              String accountId:
 *
 *              Map<CurrencyType,Deposit> currenciesDeposit:
 *
 *              Map<CurrencyType,Loan>      loans:
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
 *      Account:
 *              void openAccount():
 *
 *              void closeAccount():
 *
 *      Deposit:
 *              abstract void makeDeposit(): maintain deposits in at least three different currencies
 *
 *              abstract void withdrawal(): withdraw money from the account
 *
 *              void transferTo( ): transfer money
 *
 *              void getTransferFrom(CurrencyType cType, double transAmount)
 *     Loan:
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
 */



public abstract class Account {
    protected enum ActionType{
        DEPOSIT,WITHDRAW,TRANSFEROUT,TRANSFERIN,REQUESTLOAN,TAKEOUTLOAN,PAYBACKLOAN, INTEREST, SERVICEFEE
    }
    protected String accountId;
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

    // Account:
    public void openAccount(){

    }

    public void closeAccount() {


    }


    //Deposit:
    abstract void makeDeposit();
    abstract void withdrawal();
    public void transferTo()
    {
        //Ask user destination accountId

        //Ask user type of currency

        //Ask user amount

        //Charge a fee

        //Record above fee charging action into transactions

        //Record TRANSFEROUT action into transactions

        // Perform actual balance decrement at this.currenciesDeposit

    }
    public void getTransferFrom(CurrencyType cType, double transAmount)
    {
        //Record TRANSFERIN action into transactions

        // Perform actual balance decrement at this.currenciesDeposit

    }

    //Loan:
    abstract boolean requestLoan();
    abstract void takeOutLoan();
    abstract void payBackLoan();

    //DisplayInfo:
//    abstract void viewTransactions();
//    abstract void viewCurrentBalance();


    //Helpers:

    public double calculateInterest( double interestRate, int durationDays, double baseAmountMoney){
        return interestRate * durationDays * baseAmountMoney;
    }

    public void writeToTransactionsLog(CurrencyType cType,ActionType AType, double transAmount)

    {   double before,after;
        // Loan
        if(AType ==ActionType.PAYBACKLOAN || AType ==ActionType.TAKEOUTLOAN||AType ==ActionType.REQUESTLOAN)
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Map<CurrencyType, Deposit> getCurrenciesDeposit() {
        return currenciesDeposit;
    }

    public void setCurrenciesDeposit(Map<CurrencyType, Deposit> currenciesDeposit) {
        this.currenciesDeposit = currenciesDeposit;
    }

    public Map<CurrencyType, Loan> getLoans() {
        return loans;
    }

    public void setLoans(Map<CurrencyType, Loan> loans) {
        this.loans = loans;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    public double getDepositInterestRate() {
        return depositInterestRate;
    }

    public void setDepositInterestRate(double depositInterestRate) {
        this.depositInterestRate = depositInterestRate;
    }

    public double getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }
}
