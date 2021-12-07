import java.util.Date;

/**
 * Class Loan:
 *
 *  Variables:
 *
 *          Date startDateOfLoan:
 *
 *          Currency currency:
 *
 *  Constructors:
 *
 *          Loan(Currency currency):
 *                                  create a loan started from now(Current date)
 *
 *  Methods:
 */
public class Loan {

    private Date startDateOfLoan;

    private Currency currency;

    public Loan(Currency currency)
    {
        this.currency= currency;
        this.startDateOfLoan=new Date(); // Current date
    }
}
