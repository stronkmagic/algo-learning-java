package algoexpert;

public class ValidateStackSequence {
    public static void main(String[] args) {
//        int[] pushed1 = new int[]{4,0,1,2,3};
//        int[] popped1 = new int[]{4,2,3,0,1};
//        boolean b = validateStackSequences(pushed1, popped1);
//
//        int[] pushed2 = new int[]{1,2,3,4,5};
//        int[] popped2 = new int[]{4,5,3,2,1};
//        validateStackSequences(pushed2, popped2);

        int[] pushed3 = new int[]{1,0};
        int[] popped3 = new int[]{1, 0};
        validateStackSequences(pushed3, popped3);
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        //return greedySoltuion(pushed, popped);
        return withoutStackSoltuion(pushed, popped);
    }

    private static boolean withoutStackSoltuion(int[] pushed, int[] popped) {
        int pop = 0;
        for (int push = 0; push < pushed.length; push++) {
            int currentPush = push;
            while (currentPush >= 0  && pop < pushed.length && (pushed[currentPush] == popped[pop] || pushed[currentPush] == Integer.MIN_VALUE)) {
                if (pushed[currentPush] != Integer.MIN_VALUE) {
                    pop++;
                }
                pushed[currentPush--] = Integer.MIN_VALUE;

            }
        }

        return pop == pushed.length;
    }
}
