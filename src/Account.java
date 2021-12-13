import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *   Abstract Class Account
 *
 *   Variables:
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
>>>>>>> origin/zack
 *
 *              abstract void withdrawal(): withdraw money from the account
 *
<<<<<<< HEAD
 *              void transferTo(Account account, double amount): transfer money
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

    protected String accountId;
    protected Map<CurrencyType,Deposit> currenciesDeposit;
    protected Map<CurrencyType,Loan>  loans;
    protected List<Transaction> transactions;
    protected double depositInterestRate=0.00001;
    protected double loanInterestRate=0.00001;

    public Account(){
        this.currenciesDeposit=new HashMap<CurrencyType,Deposit>();
        this.loans= new HashMap<CurrencyType,Loan>();
        this.transactions= new ArrayList<Transaction >();
        this.currenciesDeposit.put(CurrencyType.USD,new Deposit(CurrencyType.USD,0));
        this.currenciesDeposit.put(CurrencyType.CNY,new Deposit(CurrencyType.CNY,0));
        this.currenciesDeposit.put(CurrencyType.EUR,new Deposit(CurrencyType.EUR,0));
        this.loans.put(CurrencyType.USD,new Loan(CurrencyType.USD,0));
        this.loans.put(CurrencyType.CNY,new Loan(CurrencyType.CNY,0));
        this.loans.put(CurrencyType.EUR,new Loan(CurrencyType.EUR,0));
    }

    // Account:
    public void openAccount(CurrencyType cType){
        double fee = 5;


        //Record  fee charging action into transactions
        writeToTransactionsLog(cType,ActionType.OPENACCOUNT,-1*fee);

        //Charge a fee
        this.currenciesDeposit.get(cType).deductedBy(fee);

    }

    public void closeAccount(CurrencyType cType) {

        double fee = 5;


        //Record  fee charging action into transactions
        writeToTransactionsLog(cType,ActionType.CLOSEACCOUNT,-1*fee);

        //Charge a fee
        this.currenciesDeposit.get(cType).deductedBy(fee);


    }


    //Deposit:
    abstract void makeDeposit(CurrencyType cType, double amount);
    abstract void withdrawal(CurrencyType cType, double amount);
    public void transferTo(AccountType aType)
    {
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
    abstract boolean requestLoan(CurrencyType cType, double amount);
    abstract void takeOutLoan(CurrencyType cType, double amount);
    abstract void payBackLoan(CurrencyType cType, double amount);

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
        if(AType ==ActionType.PAYBACKLOAN ||AType ==ActionType.REQUESTLOAN)
        {
            before = loans.get(cType).getAmount();
             after = before + transAmount; // +/- positive or negative
        }
        // Deposit
        else {
             before = currenciesDeposit.get(cType).getAmount();
             after = before + transAmount; // +/- positive or negative
        }

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        this.transactions.add( new Transaction( this.accountId,LocalDateTime.now(), cType,before, AType,transAmount, after));
    }

    public int calculatePeriod( String startDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate date = LocalDate.parse(startDate, formatter);
        return Period.between(date,LocalDate.now()).getDays();
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
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
