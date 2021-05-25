package leetcode;

public class MaxScoreCards{
    public static void main(String[] args) {
        int[] scores = {1,2,3,4,5,6,1};
        int k = 3;

        int[] scores2 = {2,2,2};
        int k2 = 2;
        MaxScoreCards scoreCards = new MaxScoreCards();
        int s = scoreCards.maxScore(scores, k);
        int s2 = scoreCards.maxScore(scores2, k2);
        System.out.println(s);
        System.out.println(s2);
    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int m = n-k;
        int totalSum = sum(cardPoints, 0, n-1);
        int score = 0;
        for (int i = 0; i < m; i++) {

            int curr = sum(cardPoints, i, i+m);
            score = Math.max(score, totalSum - curr);
        }
        return score;
    }

    private int sum(int[] cardPoints, int x, int y) {
        int sum = 0;
        for (int i = x; i <= y; i++) sum += cardPoints[i];
        return sum;
    }
}
