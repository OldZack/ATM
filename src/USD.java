/**
 *   Predefined Class Currency :
 *
 *   Variables:
 *
 *              enum  CurrencyType :
 *                                          USD,CNY,EUR
 *
 *              CurrencyType typeOfCurrency:
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
 * ---------------------------------------------------------------------------------------------------------------------
 *
 *  Class USD:
 *
 *  Variables:
 *
 *  Constructors:
 *
 *              USD():
 *
 *              USD(double n):
 *
 *  Methods:
 *
 */
public class USD extends Currency {

    public USD() {
        this.typeOfCurrency=CurrencyType.USD;
        this.amount=0;
    }
    public USD(double n) {
        this.typeOfCurrency=CurrencyType.USD;
        this.amount=n;
    }

}
