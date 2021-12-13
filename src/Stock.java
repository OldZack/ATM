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

public class Stock {

    public void LookUpStock(String CompanyName) throws MalformedURLException {
        String path = "https://financialmodelingprep.com/api/v3/search-name?query="+ CompanyName + "&limit=10&exchange=NASDAQ&apikey=8c2e87d9de958123a08420ecd0c747bf";
        URL url = new URL(path);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
