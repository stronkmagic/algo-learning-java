package algoexpert;

public class UnderscorifySubstring {
    public static void main(String[] args) {
        String str = "testthis is a testtest to see if testestest it works";
        String substr = "test";
        String substring = str.substring(str.length()-2, str.length()-2+substr.length());
        String[] strSplit = str.split(substr);
        System.out.println(1);
    }
}
