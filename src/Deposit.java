import java.time.LocalDate;

/**
 *
 *   Predefined Class Currency:
 *
 *   Variables:
 *
 *
 *              CurrencyType typeOfCurrency:
 *
 *              double amount:
 *
 *              LocalDate startDate: https://docs.oracle.com/javase/tutorial/datetime/iso/period.html
 *
 *   Constructors:
 *
 *                  Currency():
 *                                  empty constructor
 *
 *   Methods:
 *              getters & setters
 *
 *
 *  ---------------------------------------------------------------------------------------------------------------------
 *
 *  Class Deposit:
 *
 *  Constructors:
 *
 *              Deposit():
 *                          empty constructor
 *
 *              Deposit( CurrencyType currencyType,double amount):
 */
public class Deposit extends Currency{


    public Deposit()
    {
        super();
        this.startDateOfLoan= LocalDate.now();; // Current date
    }
    public Deposit( CurrencyType currencyType,double amount)
    {
        super();
        this.startDateOfLoan= LocalDate.now();; // Current date
        this.typeOfCurrency=currencyType;
        this.amount=amount;
    }

}

