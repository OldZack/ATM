import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *   Class Stock :
 *
 *   Variables:
 *
 *              String name:
 *
 *              Double price:
 *
 *
 *
 *   Constructors:
 *
 *
 *   Methods:
 *
 *
 */

public class Stock implements Comparable<Stock> {

    private String companyName;
    private int volume;
    private int holding;
    private double price;

    Stock(String n, int vol, double pri) throws IOException {
        this.companyName = n;
        this.volume = vol;
        this.price = pri;
        this.holding = 0;
    }

    public void add_holding ( int hol){
        this.holding += hol;
    }

    public double getPrice () {
        return price;
    }

    public double getVolume () {
        return volume;
    }

    public String print () {
        return "Symbol: " + this.companyName + "  Price: " + this.price + " Volume: " + this.volume;
    }

    @Override
    public int compareTo (Stock o){
        if (this.companyName == o.companyName) {
            return 0;
        }
        return 1;
    }
}
