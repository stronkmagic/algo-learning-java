package crackingthecoding.arraysAndStrings;

import java.util.Arrays;

public class IsUnique1 {
    public static void main(String[] args) {
        String s = "a123a";
        IsUnique1 solution = new IsUnique1();
        System.out.println(solution.isUnique(s));
    }

    private boolean isUnique(String s) {
        if (s.length() > 128) return false;
//        char[] c = s.toCharArray();
//        Arrays.sort(c);
//
//        for (int i = 1; i < c.length; i++) {
//            if (c[i] == c[i - 1]) return false;
//        }
//        boolean[] char_set = new boolean[128];
//
//        for (int i = 0; i < s.length(); i++) {
//            int val = s.charAt(i);
//            if (char_set[val]) return false;
//            char_set[val] = true;
//        }

        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }

        return true;
    }
}
