import java.util.*;

public class HashMapper{
    public static void main(String[] args){

        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("Future Islands", "A Dream of You and Me");
        hmap.put("The Cat Empire", "Brighter Than Gold");
        hmap.put("Beirut", "The Penalty");
        hmap.put("Shoos Off", "Anywhere");

        String title = hmap.get("Shoos Off");

        // System.out.println(title); //works
        // System.out.println(hmap); //works

        Set<String> keys = hmap.keySet();
        for(String key : keys){
            System.out.println(key + ": " + hmap.get(key));
        }
    }
}