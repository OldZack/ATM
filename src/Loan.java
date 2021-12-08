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
 * Class Loan:
 *
 *  Variables:
 *
 *          LocalDate startDate :  https://docs.oracle.com/javase/tutorial/datetime/iso/period.html
 *
 *
 *
 *  Constructors:
 *
 *          Loan():
 *                                  create a loan started from now(Current date)
 *
 *  Methods:
 */
public class Loan extends Currency{


    public Loan()
    {
        super();
        this.startDateOfLoan= LocalDate.now();; // Current date
    }
    public Loan( CurrencyType currencyType,double amount)
    {
        super();
        this.startDateOfLoan= LocalDate.now();; // Current date
        this.typeOfCurrency=currencyType;
        this.amount=amount;
    }

}
