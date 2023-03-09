import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.html.parser.*;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Hello world!");

        JSONObject JSONob = new JSONObject();

        JSONob.put("name", "Johan");
        JSONob.put("age", 21);

        System.out.println("Mitt namn är " + JSONob.get("name"));
        System.out.println("Jag är " + JSONob.get("age"));


        Object o = new JSONParser().parse(new FileReader("C:\\Users\\Lego_\\IdeaProjects\\jsonTest\\src\\data.json"));
        JSONObject jsonData = (JSONObject) o;

        JSONObject person = (JSONObject) jsonData.get("p1");
        String name = (String) person.get("name");
        Long age = (Long) person.get("age");

        JSONObject person2 = (JSONObject) jsonData.get("p2");
        String name2 = (String) person2.get("name");

        System.out.println("P1 Name: " + name + " " + "age :" + age);
        System.out.println("P2 Name: " + name2);

        jsonfromapi();
    }

    static void jsonfromapi() throws IOException, ParseException {
        URL url = new URL("https://api.wheretheiss.at/v1/satellites/25544");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        if (conn.getResponseCode() == 200) {
            System.out.println("koppling lyckades");

            StringBuilder strData = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                strData.append(scanner.nextLine());
            }
            scanner.close();
            JSONObject dataObject = (JSONObject) new JSONParser().parse(String.valueOf(strData));
            String visible = (String) dataObject.get("visibility");
            System.out.println(visible);
        }
        else System.out.println("koppling misslyckades");
    }
}