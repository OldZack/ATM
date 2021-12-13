import java.time.LocalDate;
import java.time.LocalDateTime;

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
 *              LocalDateTime startDate: https://docs.oracle.com/javase/tutorial/datetime/iso/period.html
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
        this.startDate= LocalDateTime.now().format(Database.formatter);; // Current date
    }

    public Deposit( CurrencyType currencyType,double amount)
    {
        super();
        this.startDate= LocalDateTime.now().format(Database.formatter);; // Current date
        this.typeOfCurrency=currencyType;
        this.amount=amount;
    }

}

