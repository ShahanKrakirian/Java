public class StringManipulatorTest{
    public static void main(String[] args){
        //Import String Manipulator
        StringManipulator manipulator = new StringManipulator();

        //Trim and Concat 
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str); // HelloWorld 

        //Get Index or Null (String, char)
        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

        //Get Index or Null (String, String)
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer aa = manipulator.getIndexOrNull(word, subString);
        Integer bb = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(aa); // 2
        System.out.println(bb); // null

        //Concat Substring
        String otherword = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(otherword); // eworld
    }
}