import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        JSONObject JSONob = new JSONObject();

        JSONob.put("name", "Johan");
        JSONob.put("age", 21);

        System.out.println("Mitt namn är " + JSONob.get("namn"));
        System.out.println("Jag är " + JSONob.get("age"));
    }
}