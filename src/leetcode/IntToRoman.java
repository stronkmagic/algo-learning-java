package leetcode;


public class IntToRoman {
    public static void main(String[] args) {
        int test = 1994;
        System.out.println(intToRoman(test));
        int test2 = 394;
        System.out.println(intToRoman(test2));
    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int times = num / values[i];
            num %= values[i];
            while (times-- > 0) {
                result.append(romanSymbols[i]);
            }
        }
        return result.toString();
    }
}
