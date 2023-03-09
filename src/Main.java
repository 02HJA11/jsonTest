import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

        System.out.println("P1 Name: " + name);
    }
}