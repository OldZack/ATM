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
 *  Class EUR:
 *
 *  Variables:
 *
 *  Constructors:
 *
 *              EUR():
 *
 *              EUR(double n):
 *
 *  Methods:
 *
 */
public class EUR extends Currency {

    public EUR() {
        this.typeOfCurrency=CurrencyType.EUR;
        this.amount=0;
    }
    public EUR(double n) {
        this.typeOfCurrency=CurrencyType.EUR;
        this.amount=n;
    }

}
