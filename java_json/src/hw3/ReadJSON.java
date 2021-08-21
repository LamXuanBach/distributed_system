package hw3;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSON {
    public static void main(String[] args) {
        try {
            // read file to Object
            Object obj = new JSONParser().parse(new FileReader("src/hw3/customer.json"));
            // covert Object to Json
            JSONObject jo = (JSONObject) obj;

            // read id
            int id = ((Long) jo.get("id")).intValue();
            // read age
            int age = ((Long) jo.get("age")).intValue();
            
            // read name
            List<String> names = new ArrayList<>();
            JSONArray nameArr = (JSONArray) jo.get("name");
            for (Object nameObj : nameArr) 
                names.add((String) nameObj);

            //read account
            List<Account> accounts = new ArrayList<>();
            JSONArray accoutnArr = (JSONArray) jo.get("accounts");
            for (int i = 0; i < accoutnArr.size(); i++) {
                JSONObject accountObj = (JSONObject) accoutnArr.get(i);
                int accountID = ((Long) accountObj.get("accountID")).intValue();
                int balance = ((Long) accountObj.get("balance")).intValue();
                accounts.add(new Account(accountID, balance));
            }

            // create customer
            Customer customer = new Customer(id, age, names, accounts);
            System.out.println(customer);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

