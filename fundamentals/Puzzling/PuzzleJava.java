import java.util.*;

public class PuzzleJava{
    public static void main(String[] args){
        
        // Integer[] arr = {3, 5, 1, 2, 7, 9, 8, 13, 25, 32};
        // ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        
        // System.out.println(returnGreater(list));

        // String[] arr = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        // ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
        
        // System.out.println(shuffleNames(list));

        // String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        // ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));

        // randomLetter(list);

        // System.out.println(randomInt());

        System.out.println(randomString());




    }

    public static ArrayList<Integer> returnGreater(ArrayList<Integer> list){
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        Integer sum = 0;
        for (int i=0; i<list.size(); i++){
            if (list.get(i) > 10){
                returnList.add(list.get(i));
            }
            sum = sum + list.get(i);
        }
        System.out.println(sum);
        return returnList;
    }

    public static ArrayList<String> shuffleNames(ArrayList<String> list){
        ArrayList<String> returnList = new ArrayList<String>();
        Collections.shuffle(list);
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
            if (list.get(i).length() > 5){
                returnList.add(list.get(i));
            }
        }
        return returnList;
    }
    public static void randomLetter(ArrayList<String> list){
        Collections.shuffle(list);
        System.out.println(list);
        String last = list.get(25);
        System.out.println(last);
        if (last == "a" || last == "e" || last == "i" || last == "o" || last == "u"){
            System.out.println("Randomly found a vowel at the end of our array.");
        }
    }
    public static ArrayList<Integer> randomInt(){
        Integer min = 100;
        Integer max = 0;
        Random r = new Random();
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int i=1; i<=10; i++){
            returnList.add(r.nextInt(45)+55);
        }
        for (int j=0; j<returnList.size(); j++){
            if (returnList.get(j) > max){
                max = returnList.get(j);
            }
            if (returnList.get(j) < min){
                min = returnList.get(j);
            }
        }
        Collections.sort(returnList);
        System.out.println(min);
        System.out.println(max);
        return returnList;
    }
    public static ArrayList<String> randomString(){
        Random r = new Random();
        String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
        ArrayList<String> returnList = new ArrayList<String>();
        String answer;
        for (int j=0; j<6; j++){
            answer = "";
            for (int i=0; i<6; i++){
            answer = answer + list.get(r.nextInt(25));
            }
            returnList.add(answer);
        }
        return returnList;
    }
}