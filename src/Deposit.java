import java.time.LocalDate;

/**
 *
 *   Class Currency :
 *
 *   Variables:
 *
 *
 *              CurrencyType typeOfCurrency:
 *
 *              double amount:
 *
 *              LocalDate startDate:
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

