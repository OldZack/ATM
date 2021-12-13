import java.io.*;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Class Database
 *
 *  Variables:
 *
 *
 *
 *
 *
 *
 *  Constructors:
 *
 *  Methods:
 *
 *
 */


public class Database {



    private final static String curDir=  System.getProperty("user.dir");

    private static List<User> users =  new ArrayList<User>() ;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    // Empty constructor
    public Database() throws URISyntaxException {
    }

    public static void ReadUserFromLocal() throws IOException, URISyntaxException {

        //reset
        users =  new ArrayList<User>() ;

        //read
        Reader reader = Files.newBufferedReader( Paths.get(curDir+ "/ATM/Users.json"));

        Type listOfUserObject = new TypeToken<ArrayList<Customer>>() {}.getType();

        Gson gson = new Gson();

        List<User> outputList = gson.fromJson(reader, listOfUserObject);


    if(outputList!=null)
        for( User u : outputList)
        {

            // insert local record to list
            users.add(u);
        }
        reader.close();

    }

    public static void WriteUserToLocal() throws IOException, URISyntaxException {

        String path = curDir+ "/ATM/Users.json";


        //write
        FileWriter jsonWriter = new FileWriter(path,false);

        Gson gson = new Gson();



        String jsonString = gson.toJson(users);

        jsonWriter.append(jsonString);

        jsonWriter.flush();
        jsonWriter.close();
    }

    public static List<User> getUsers() {
        return users;
    }
    public static void addUser(User u)
    {
        users.add(u);
    }

    public static void setUsers(List<User> users) {
        Database.users = users;
    }

    public static void main(String args[]) throws IOException, URISyntaxException {
        User u = new Customer("alansun","alan");
        Customer c = (Customer) u ;
        c.createccount(AccountType.SAVING,CurrencyType.USD,100);
        User u2 = new Customer("alan","alan");
        Customer c2 = (Customer) u2 ;
        c2.createccount(AccountType.SAVING,CurrencyType.USD,100);
       // Transaction temp = new Transaction("hello",LocalDateTime.now(),CurrencyType.USD,200,ActionType.TRANSFEROUT,-100,100);
        ReadUserFromLocal();
        //WriteUserToLocal();
        System.out.println(users.size());
    }

    }
