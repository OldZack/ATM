import java.io.*;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Class Database
 *
 *  Variables:
 *              final static String curDir: System.getProperty("user.dir")
 *
 *              static Map<String,User> users:  these User s are indeed all Customer s
 *
 *              static final DateTimeFormatter formatter:
 *
 *
 *  Constructors:
 *
 *          Database():
 *
 *  Methods:
 *
 *          void ReadUserFromLocal(String userName):
 *
 *                  try to read userName.json from local, if not found create such a file
 *
 *         void WriteUserToLocal(String userName):
 *
 *                 try to write userName.json from local, if not found create such a file then write
 *
 *         void addUser(User u):
 *
 *                  add a new User to users
 *
 */


public class Database {



    private final static String curDir=  System.getProperty("user.dir");

    private static Map<String,User> users =  new HashMap<String,User>() ;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    // Empty constructor
    public Database() throws URISyntaxException {
    }

    public static void ReadUserFromLocal(String userName) throws IOException, URISyntaxException {
        //String path =curDir+ "/ATM/"+userName+".json";

        String path =curDir+ "/"+userName+".json";

        File f = new File(path);

        if(!f.exists())
        {
            f.createNewFile();
        }


        //read
        Reader reader = Files.newBufferedReader( Paths.get(path));

        //Type listOfUserObject = new TypeToken<ArrayList<Customer>>() {}.getType();

        Gson gson = new Gson();

        users.put(userName,gson.fromJson(reader, Customer.class));


//    if(outputList!=null)
//        for( User u : outputList)
//        {
//
//            // insert local record to list
//            users.add(u);
//        }
        reader.close();

    }

    public static void WriteUserToLocal(String userName) throws IOException, URISyntaxException {

        //String path = curDir+ "/ATM/"+userName+".json";

        String path =curDir+ "/"+userName+".json";

        File f = new File(path);

        if(!f.exists())
        {
            f.createNewFile();
        }

        //write
        FileWriter jsonWriter = new FileWriter(path,false);

        Gson gson = new Gson();

        String jsonString = gson.toJson(users.get(userName));

        jsonWriter.append(jsonString);

        jsonWriter.flush();
        jsonWriter.close();
    }

    public static Map<String, User> getUsers() {
        return users;
    }

    public static void setUsers(Map<String, User> users) {
        Database.users = users;
    }
    public static void addUser(User u)
    {
        Database.users.put(u.getUserName(),u);
    }

    public static void main(String args[]) throws IOException, URISyntaxException {
        User u = new Customer("C","alan");
        Customer c = (Customer) u ;
        c.createAccount(AccountType.SAVING,CurrencyType.USD,100);

        c.getSavingAccount().makeDeposit(CurrencyType.USD,6000);
        WriteUserToLocal(c.getUserName());
//        User u2 = new Customer("B","alan");
//        Customer c2 = (Customer) u2 ;
//        c2.createAccount(AccountType.SAVING,CurrencyType.USD,100);

       // Transaction temp = new Transaction("hello",LocalDateTime.now(),CurrencyType.USD,200,ActionType.TRANSFEROUT,-100,100);
        ReadUserFromLocal("alan");
        //WriteUserToLocal();
        System.out.println(users.size());


        System.out.println(LocalDateTime.now().format(Database.formatter).toString());
    }

    }
