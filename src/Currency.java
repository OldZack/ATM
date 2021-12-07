/**
 *
 *   Class Currency :
 *
 *   Variables:
 *
 *              enum  CurrencyType :
 *
 *                                      USD,CNY,EUR
 *
 *              String typeOfCurrency:
 *
 *              double amount:
 *
 *
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
    enum CurrencyType
    {
        USD, CNY, EUR;
    }

    protected CurrencyType typeOfCurrency;

    protected double amount;

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
