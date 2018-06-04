import java.util.ArrayList;
import java.util.Arrays;

public class basic13{
    public static void main(String[] args){
        // oneTo255();
        // sum();

        // ArrayList<Object> list = new ArrayList<Object>(Arrays.asList(5, 10, 15, "Added by 5"));
        // iterate(list);

        // Integer[] arr = {5, 10, 15, 5, 2, 50};
        // ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        // System.out.println(max(list));

        // Double[] arr = {102.2, 250.0, 140.0, 30.0, 150.0};
        // ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(arr));
        // System.out.println(ave(list));

        // System.out.println(oddArray());

        Integer[] arr = {5, 10, 2, 4, 6, 7, 9};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        // System.out.println(greaterThanY(list, 5));

        // System.out.println(squareValues(list));

        // System.out.println(removeNegatives(list));

        // System.out.println(maxMinAve(list));

        System.out.println(shiftValues(list));

    }

    public static void oneTo255(){
        for(int i=1; i<256; i=i+2){
            System.out.print(i + " ");
        }
    }
    public static void sum(){
        int sum = 0;
        for(int i=0; i<256; i++){
            sum = sum + i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }
    public static void iterate(ArrayList list){
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static int max(ArrayList<Integer> list){
        Integer max = list.get(0);
        for (int i=0; i<list.size(); i++){
            if(list.get(i) >= max){
                max = list.get(i);
            }
        }
        return max;
    }
    public static double ave(ArrayList<Double> list){
        Double sum = 0.0;
        for (int i=0; i<list.size(); i++){
            sum = sum + list.get(i);
        }
        return sum/list.size();
    }
    public static ArrayList<Integer> oddArray(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<256; i=i+2){
            list.add(i);
        }
        return list;
    }
    public static ArrayList<Integer> greaterThanY(ArrayList<Integer> list, Integer num){
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int i=0; i<list.size(); i++){
            if (list.get(i) > num){
                returnList.add(list.get(i));
            }
        }
        return returnList;
    }
    public static ArrayList<Integer> squareValues(ArrayList<Integer> list){
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int i=0; i<list.size(); i++){
            returnList.add(list.get(i) * list.get(i));
        }
        return returnList;
    }
    public static ArrayList<Integer> removeNegatives(ArrayList<Integer> list){
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int i=0; i<list.size(); i++){
            if (list.get(i) < 0){
                returnList.add(0);
            } else {
                returnList.add(list.get(i));
            }
        }
        return returnList;
    }
    public static ArrayList<Object> maxMinAve(ArrayList<Integer> list){
        ArrayList<Object> returnList = new ArrayList<Object>();
        Integer max = list.get(0);
        Integer min = list.get(0);
        Double sum = 0.0;
        for (int i=0; i<list.size(); i++){
            if (list.get(i) > max){
                max = list.get(i);
            }
            if (list.get(i) < min){
                min = list.get(i);
            }
            sum = sum + list.get(i);
        }
        returnList.add(max);
        returnList.add(min);
        returnList.add(sum/list.size());
        return returnList;
    }
    public static ArrayList<Integer> shiftValues(ArrayList<Integer> list){
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int i=1; i<list.size(); i++){
            returnList.add(list.get(i));
        }
        returnList.add(0);
        return returnList;
    }
}