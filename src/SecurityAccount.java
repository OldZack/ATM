
/**
 *   Predefined Abstract Class Account
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
 *              void openAccount(String accountType, String currencyType, double amount):
 *              Parameter: the account type, currency type, and initial deposit.
 *
 *              void closeAccount(Account account):
 *
 *      Deposit:
 *              abstract void makeDeposit(Account account, double amount): maintain deposits in at least three different currencies
 *              Parameter: account(which account to deposit in), amount(the money to deposit)
 *
 *              abstract void withdrawal(Account account, double amount): withdraw money from the account
 *
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


    //Constructor
    public SecurityAccount()
    {

    }
    public SecurityAccount(CurrencyType cType, double amount,String ownerName)
    {
        super( ownerName);
        this.currenciesDeposit.put(cType,new Deposit(cType,  amount));
        openAccount(cType);

    }

    //Deposit:
    public void makeDeposit(CurrencyType cType, double amount)
    {
        //Record Deposit action into transactions
        writeToTransactionsLog(cType,ActionType.DEPOSIT,amount);

        // Perform actual balance increment at this.currenciesDeposit
        this.currenciesDeposit.get(cType).increasedBy(amount);

    }
    public void withdrawal(CurrencyType cType, double amount){

        double fee = 1;

        //interest
        if(reachBalanceToGainInterest()) // apply only to USD
        {

            //calculate
            int duration = calculatePeriod(this.currenciesDeposit.get(cType).getStartDate());
            double baseAmount = this.currenciesDeposit.get(cType).getAmount();
            double interest = calculateInterest(depositInterestRate,duration, baseAmount);

            //log
            writeToTransactionsLog(cType,ActionType.INTEREST,interest);

            //actual increment
            this.currenciesDeposit.get(cType).increasedBy(interest);
        }
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

        //Record TAKEOUTLOAN action into transactions
        writeToTransactionsLog(cType,ActionType.TAKEOUTLOAN,amount);


        //Perform actual balance increment at this.currenciesDeposit
        this.currenciesDeposit.get(cType).increasedBy(amount);

        // set hadBeenWithdrawn to true
        this.loans.get(cType).setHasBeenWithdrawn(true);
    }
    public void payBackLoan(CurrencyType cType,double amount)
    {

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






    // check if have more than 5000 USD
    public boolean reachBalanceToGainInterest()
    {
        if(this.currenciesDeposit.containsKey(CurrencyType.USD))
        {
            return this.currenciesDeposit.get(CurrencyType.USD).getAmount() >5000.0 ? true : false;
        }
        return false;
    }

    // check if have more than 5000 USD
    public boolean reachBalanceToPlayStock()
    {
        if(this.currenciesDeposit.containsKey(CurrencyType.USD))
        {
            return this.currenciesDeposit.get(CurrencyType.USD).getAmount() >5000.0 ? true : false;
        }
        return false;
    }

    // check if account will be less than 2500 USD after
    public boolean willBeLowBalance(double tryToTransfer)
    {
        if(this.currenciesDeposit.containsKey(CurrencyType.USD))
        {
            return this.currenciesDeposit.get(CurrencyType.USD).getAmount()-tryToTransfer <2500.0 ? true : false;
        }
        return false;
    }

}
