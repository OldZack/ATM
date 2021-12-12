import javax.print.DocFlavor;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Database
 *
 *  Variables:
 *
 *  Constructors:
 *
 *  Methods:
 *
 *      List<String> ReadTransactionFromLocal(String fileName)
 *
 *      void WriteTransactionToLocal():
 *
 */


public class Database {

    private final static URL resource = ATM.class.getResource("Transactions.csv"); // xx.csv


    // Empty constructor
    public Database() throws URISyntaxException {
    }

    public static List<String> ReadTransactionFromLocal() throws IOException, URISyntaxException {

        String path = Paths.get(resource.toURI()).toString();

        //read
        BufferedReader csvReader = new BufferedReader( new FileReader(path));

        //csvReader.readLine();// read command try to consume the first(Header) line

        String row;

        ArrayList<String> transactions = new ArrayList<String>();

        while (( row = csvReader.readLine()) != null) {
            //String oneTransaction = String.join(" ",row.split(",",5));
            transactions.add(row);
        }
        csvReader.close();

        return transactions;

    }

    public static void WriteTransactionToLocal(String transaction) throws IOException, URISyntaxException {

        String path = Paths.get(resource.toURI()).toString();

        //write
        FileWriter csvWriter = new FileWriter(path, true);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        csvWriter.append((LocalDateTime.now().format(formatter)).toString() + "," + transaction + "\n");

        csvWriter.flush();
        csvWriter.close();
    }
//    public static void main( String args[]) throws IOException, URISyntaxException {
//        WriteTransactionToLocal("hello i am jeff");
//        List<String > temp = ReadTransactionFromLocal();
//
//        for ( String s: temp)
//        {
//            System.out.println(s);
//        }
//
//    }

    }
