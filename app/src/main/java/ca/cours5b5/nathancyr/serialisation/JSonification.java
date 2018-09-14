package ca.cours5b5.nathancyr.serialisation;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.Map;

import ca.cours5b5.nathancyr.modeles.MParametres;

public class JSonification {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static Map<String, Object> enObjetJson(String json) {
        Map<String, Object> objet = gson.fromJson(json, Map.class);
        return objet;
    }
    public static String enChaine(Map<String, Object> objetJson){
        String temp = gson.toJson(objetJson);
        return temp;

}
}