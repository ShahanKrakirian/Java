public class StringManipulator{
    public String trimAndConcat(String string1, String string2){
        String str1 = string1.trim();
        String str2 = string2.trim();
        return str1.concat(str2);
    }
    public Integer getIndexOrNull(String string, char letter){
        if (string.indexOf(letter) == -1){
            return null;
        } else {
            return string.indexOf(letter);
        }
    }
    public Integer getIndexOrNull(String string1, String string2){
        if (string1.indexOf(string2) == -1){
            return null;
        } else { 
            return string1.indexOf(string2);
        }
    }
    public String concatSubstring(String string1, int int1, int int2, String string2){
        return (string1.substring(int1, int2)).concat(string2);
    }
}