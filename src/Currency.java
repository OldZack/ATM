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
 */


public class Currency {

    protected CurrencyType typeOfCurrency;

    protected double amount;

    protected LocalDate startDateOfLoan;

    public Currency(){

    }

    public CurrencyType getTypeOfCurrency() {
        return typeOfCurrency;
    }

    public void setTypeOfCurrency(CurrencyType typeOfCurrency) {
        this.typeOfCurrency = typeOfCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
