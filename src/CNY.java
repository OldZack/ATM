/**
 *   Predefined Class Currency :
 *
 *   Variables:
 *
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
 *  Class CNY:
 *
 *  Variables:
 *
 *  Constructors:
 *
 *              CNY():
 *
 *              CNY(double n):
 *
 *  Methods:
 *
 */
public class CNY extends Currency {

    public CNY() {
        this.typeOfCurrency=CurrencyType.CNY;
        this.amount=0;
    }
    public CNY(double n) {
        this.typeOfCurrency=CurrencyType.CNY;
        this.amount=n;
    }

}
