
/**
 *   Predefined Abstract Class Account
 *
 *   Variables:
 *              String ownerName:
 *
 *              String accountId:
 *
 *              Map<CurrencyType,Deposit> currenciesDeposit:
 *
 *              Map<CurrencyType,Loan>     loans:
 *
 *              List<Transaction>  transactions:  date ,currencyType, before, action type, transaction amount, after
 *
 *              double depositInterestRate:
 *
 *              double loanInterestRate:
 *
 *   Constructors:
 *              Account():
 *
 *              Account(String ownerName):
 *
 *   Methods:
 *
 *      Account:
 *              void openAccount(CurrencyType cType):  start an account with deposit in cType currency
 *
 *              void closeAccount(CurrencyType cType):
 *
 *      Deposit:
 *              abstract void makeDeposit(): maintain deposits in at least three different currencies
 *
 *              abstract void withdrawal(): withdraw money from the account
 *
 *              void transferTo(AccountType aType, CurrencyType cType,double amount): transfer money
 *
 *
 *     Loan:
 *              abstract boolean requestLoan(): request loan, return true if request get approved, otherwise false
 *
 *              abstract void takeOutLoan(): take out loans (if they have collateral)
 *
 *              abstract void payBackLoan(): pay the loans on this account
 *
 *      DisplayInfo:
 *
 *              //abstract void viewTransactions():
 *
 *              //abstract void viewCurrentBalance():
 *
 *      Helpers:
 *
 *              void writeToTransactionsLogCurrencyType cType,ActionType AType, double transAmount)
 *
 *              double calculateInterest( double interestRate, int durationDays, double baseAmountMoney):
 *
 *              int calculatePeriod( String startDate):
 *
 *              getters & setters
 *
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *   Class CheckingAccount extends Account
 *
 *   Variables:
 *
 *   Constructors:
 *
 *              CheckingAccount():
 *
 *              CheckingAccount(CurrencyType cType, double amount,String ownerName):
 *
 *                  Note: cType just the currency type of the first deposit made. One CheckingAccount can have 3 types of currency deposits at the same time.
 *
 *
 *   Methods:
 *
 *              void makeDeposit(CurrencyType cType, double amount):
 *
 *              void withdrawal(CurrencyType cType, double amount):
 *
 *              boolean requestLoan(CurrencyType cType, double amount):
 *
 *              void takeOutLoan(CurrencyType cType,double amount):
 *
 *              void payBackLoan(CurrencyType cType,double amount):
 *
 *
 *
 *
 */

public class CheckingAccount extends Account {
    //Constructor
    public CheckingAccount()
    {
        super();


    }
    public CheckingAccount(CurrencyType cType, double amount,String ownerName)
    {
        super( ownerName);
        this.currenciesDeposit.put(cType,new Deposit(cType,  amount));
        openAccount(cType);

    }
    //Deposit:
    public void makeDeposit(CurrencyType cType, double amount)
    {

        double fee = 1;

        //Record  fee charging action into transactions
        writeToTransactionsLog(cType,ActionType.SERVICEFEE,-1*fee);

        //Charge a fee
        this.currenciesDeposit.get(cType).deductedBy(fee);


        //Record Deposit action into transactions
        writeToTransactionsLog(cType,ActionType.DEPOSIT,amount);

        // Perform actual balance increment at this.currenciesDeposit
        this.currenciesDeposit.get(cType).increasedBy(amount);

    }
    public void withdrawal(CurrencyType cType, double amount){

        double fee = 1;

        //Record  fee charging action into transactions
        writeToTransactionsLog(cType,ActionType.SERVICEFEE,-1*fee);

        //Charge a fee
        this.currenciesDeposit.get(cType).deductedBy(fee);

        //Record Deposit action into transactions
        writeToTransactionsLog(cType,ActionType.WITHDRAW,amount);

        // Perform actual balance decrement at this.currenciesDeposit
        this.currenciesDeposit.get(cType).deductedBy(amount);
    }


    //Loan:
    public boolean requestLoan(CurrencyType cType, double amount)
    {
        //Ask user type of currency

        //Ask user amount

        double fee = 1;

        //Record  fee charging action into transactions
        writeToTransactionsLog(cType,ActionType.SERVICEFEE,-1*fee);

        //Charge a fee
        this.currenciesDeposit.get(cType).deductedBy(fee);

        //Add a new loan to this.loans
        this.loans.put(cType,new Loan(cType,amount));

        //Record REQUESTLOAN action into transactions

        writeToTransactionsLog(cType,ActionType.REQUESTLOAN,0);




        return false;
    }
    public void takeOutLoan(CurrencyType cType,double amount)
    {

        double fee = 1;

        //Record  fee charging action into transactions
        writeToTransactionsLog(cType,ActionType.SERVICEFEE,-1*fee);

        //Charge a fee
        this.currenciesDeposit.get(cType).deductedBy(fee);

        //Record TAKEOUTLOAN action into transactions
        writeToTransactionsLog(cType,ActionType.TAKEOUTLOAN,amount);


        //Perform actual balance increment at this.currenciesDeposit
        this.currenciesDeposit.get(cType).increasedBy(amount);

        // set hadBeenWithdrawn to true
        this.loans.get(cType).setHasBeenWithdrawn(true);
    }
    public void payBackLoan(CurrencyType cType,double amount)
    {   double fee = 1;

        //Record  fee charging action into transactions
        writeToTransactionsLog(cType,ActionType.SERVICEFEE,-1*fee);

        //Charge a fee
        this.currenciesDeposit.get(cType).deductedBy(fee);


        //Update the loan amount , plus the interest

        //calculate
        int duration = calculatePeriod(this.loans.get(cType).getStartDate());
        double baseAmount = this.loans.get(cType).getAmount();
        double interest = calculateInterest(loanInterestRate,duration, baseAmount);

        //log
        writeToTransactionsLog(cType,ActionType.INTEREST,-1*interest);

        //actual increment of loan
        this.loans.get(cType).increasedBy(-1*interest);


        //Record PAYBACKLOAN action into transactions
        writeToTransactionsLog(cType,ActionType.PAYBACKLOAN,amount);

        //Perform actual balance decrement at this.currenciesDeposit
        this.currenciesDeposit.get(cType).deductedBy(amount);


        //remove the loan from this.loans
        this.loans.remove(cType);
    }



    //DisplayInfo:


}
