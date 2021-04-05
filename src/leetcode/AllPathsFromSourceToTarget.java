package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {

        int[][] graph = {
                {1,2},
                {3},
                {3},
                {}
        };

        AllPathsFromSourceToTarget solution = new AllPathsFromSourceToTarget();
        List<List<Integer>> lists = solution.allPathsSourceTarget(graph);

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        helper(graph, 0, path, res);

        return res;
    }

    private void helper(int[][] graph, int node, List<Integer> currPath, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(currPath));
            return;
        }

        for (int visitIdx: graph[node]) {
            currPath.add(visitIdx);
            helper(graph, visitIdx, currPath, res);
            currPath.remove(currPath.size() - 1);
        }
    }
}
