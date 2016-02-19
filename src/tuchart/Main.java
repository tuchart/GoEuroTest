package tuchart;

import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Artyom on 16.02.2016.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<String> fieldsToPrint = new ArrayList<String>();
        fieldsToPrint.addAll(Arrays.asList("_id", "name", "type", "latitude", "longitude")); //define which fields we should print in .csv file

        JSONParserClass jsonParserClass = new JSONParserClass();
        jsonParserClass.checkParams(args); //it will check if entry params are right
        try {
            JSONArray jsonArray = jsonParserClass.getJSONs("http://api.goeuro.com/api/v2/position/suggest/en/", jsonParserClass.getCityName());
            jsonParserClass.createCSV(jsonArray, fieldsToPrint);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //ClassLoader loader = Main.class.getClassLoader();
        //System.out.println(loader.getResource("tuchart/Main.class"));

    }
}
