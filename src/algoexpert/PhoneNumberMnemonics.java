package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberMnemonics {
    private static HashMap<Character, String[]> DIGIT_LETTERS = new HashMap<>();

    static {
        DIGIT_LETTERS.put('0', new String[] {"0"});
        DIGIT_LETTERS.put('1', new String[] {"1"});
        DIGIT_LETTERS.put('2', new String[] {"a", "b", "c"});
        DIGIT_LETTERS.put('3', new String[] {"d", "e", "f"});
        DIGIT_LETTERS.put('4', new String[] {"g", "h", "i"});
        DIGIT_LETTERS.put('5', new String[] {"j", "k", "l"});
        DIGIT_LETTERS.put('6', new String[] {"m", "n", "o"});
        DIGIT_LETTERS.put('7', new String[] {"p", "q", "r", "s"});
        DIGIT_LETTERS.put('8', new String[] {"t", "u", "v"});
        DIGIT_LETTERS.put('9', new String[] {"w", "x", "y", "z"});
    }

    // O(N * 4^N)
    public static ArrayList<String> phoneNumberMnemonicsIterative(String phoneNumber) {
        // Write your code here.
        ArrayList<String> mnemonics = new ArrayList<>();
        mnemonics.add("");
        for (int i = 0; i < phoneNumber.length(); i++) {
            ArrayList<String> current = new ArrayList<>();
            String[] letters = DIGIT_LETTERS.get(phoneNumber.charAt(i));

            for (String existingVals : mnemonics){
                for (String letter : letters) {
                    current.add(existingVals+letter);
                }
            }
            mnemonics = current;
        }
        return mnemonics;
    }

    public static ArrayList<String> phoneNumberMnemonicsRecursive(String phoneNumber) {
        // Write your code here.
        ArrayList<String> mnemonics = new ArrayList<>();

        String[] currentMnemonic = new String[phoneNumber.length()];
        Arrays.fill(currentMnemonic, "0");

        phoneNumberMnemonics(0, phoneNumber, currentMnemonic, mnemonics);

        return mnemonics;
    }

    private static void phoneNumberMnemonics(int idx, String phoneNumber, String[] currentMnemonic, ArrayList<String> mnemonics) {
        if (idx == phoneNumber.length()) {
            String mnemonic = String.join("", currentMnemonic);
            mnemonics.add(mnemonic);
        } else {
            char digit = phoneNumber.charAt(idx);
            String[] letters = DIGIT_LETTERS.get(digit);
            for (String letter: letters) {
                currentMnemonic[idx] = letter;
                phoneNumberMnemonics(idx + 1, phoneNumber, currentMnemonic, mnemonics);
            }
        }
    }

    public static void main(String[] args) {

        long startTime2 = System.nanoTime();
        ArrayList<String> stringArrayListI = phoneNumberMnemonicsIterative("1905");
        long stopTime2 = System.nanoTime();
        System.out.println(stopTime2 - startTime2);

        long startTime1 = System.nanoTime();
        ArrayList<String> stringArrayListR = phoneNumberMnemonicsRecursive("1905");
        long stopTime1 = System.nanoTime();
        System.out.println(stopTime1 - startTime1);
    }
}
