package quanduong.com.demomyhotkey.utils;

public class StringUtils {

    public static int WordCount(String str){
        String words = str.trim();
        if (words.isEmpty()) return 0;
        return words.split("\\s+").length; // separate string around spaces
    }

}
