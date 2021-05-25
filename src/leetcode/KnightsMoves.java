package leetcode;

import java.util.*;

public class KnightsMoves {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minKnightMoves(5,5);
    }

    static class Solution {
        public int minKnightMoves(int x, int y) {
            int[][] moves = new int[][]{
                    {2,1},
                    {1,2},
                    {-1,2},
                    {-2,1},
                    {-2,-1},
                    {-1,-2},
                    {1,-2},
                    {2,-1}
            };

            Set<Move> visited = new HashSet<>();

            Queue<Move> queue = new LinkedList<Move>();
            int distance = distance(x,0,y,0);
            queue.add(new Move(0,0,0));
            while (!queue.isEmpty()) {
                Move currentMove = queue.poll();

                if (currentMove.x == x && currentMove.y == y) return currentMove.move;
//                if (visited.contains(currentMove)) continue;
//                visited.add(currentMove);
                for (int[] move: moves) {
                    int possibleX = currentMove.x + move[0];
                    int possibleY = currentMove.y + move[1];
                    int currDistance = distance(possibleX,x,possibleY,y);
                    if (distance >= currDistance) {
                        distance = currDistance;
                        Move newMove = new Move(currentMove.x + move[0], currentMove.y + move[1], currentMove.move+1);
                        queue.add(newMove);
                    }
                }
            }
            //Moves not found
            return -1;
        }

        private int distance(int x1, int x2, int y1, int y2) {
            return Math.abs(x1-x2) + Math.abs(y1-y2);
        }

        class Move {
            int x;
            int y;
            int move;
            Move(int x, int y, int move) {
                this.x = x;
                this.y = y;
                this.move = move;
            }
        }
    }
}
