package crackingthecoding.arraysAndStrings;

public class StringCompressed {
    public static void main(String[] args) {
        String test = "aabcCCCaaaaaaaaaaaab";
        StringCompressed s = new StringCompressed();

        System.out.println(s.compress(test));
    }

    private String compress(String originalString) {

        StringBuilder sb = new StringBuilder();

        int prevIdx = 0;

        for (int i = 1; i < originalString.length(); i++) {
            if (originalString.charAt(i - 1) != originalString.charAt(i)) {
                sb.append(originalString.charAt(i-1));
                sb.append(i-prevIdx);
                prevIdx = i;    
            }
        }

        sb.append(originalString.charAt(originalString.length() - 1));
        sb.append(originalString.length() - prevIdx);

        String res = sb.toString();
        return  (originalString.length() <= res.length()) ? originalString : res;
    }
}
