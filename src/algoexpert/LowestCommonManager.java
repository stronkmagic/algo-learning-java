package algoexpert;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

public class LowestCommonManager {
    public static void main(String[] args) {
        OrgChart topManager = new OrgChart('A');
        OrgChart B = new OrgChart('B');
        OrgChart C = new OrgChart('C');
        OrgChart D = new OrgChart('D');
        OrgChart E = new OrgChart('E');
        OrgChart F = new OrgChart('F');
        OrgChart G = new OrgChart('G');
        OrgChart H = new OrgChart('H');
        OrgChart I = new OrgChart('I');
        topManager.directReports = Arrays.asList(B, C);
        B.directReports = Arrays.asList(D, E);
        C.directReports = Arrays.asList(F, G);
        D.directReports = Arrays.asList(H, I);

        OrgChart lowestCommonBeach = getLowestCommonManager(topManager, E, I);
        System.out.println(lowestCommonBeach.name);
    }

    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        // Write your code here.
        if (equals(topManager, reportTwo) || equals(topManager, reportOne)) return topManager;
        Stack<OrgChart> stackOne = new Stack<>();
        Stack<OrgChart> stackTwo = new Stack<>();
        //List<Stack<OrgChart>> list = new ArrayList<>();

        dfs(topManager, reportOne, stackOne);
        dfs(topManager, reportTwo, stackTwo);

        while (stackOne.size() != stackTwo.size()) {
            if (stackOne.size() > stackTwo.size()) {
                stackOne.pop();
            }

            if (stackTwo.size() > stackOne.size()) {
                stackTwo.pop();
            }
        }

        while (stackOne.peek() != stackTwo.peek()) {
            if (!stackOne.isEmpty()) stackOne.pop();
            if (!stackTwo.isEmpty()) stackTwo.pop();
        }

        return stackOne.peek(); // Replace this line.
    }

    private static boolean dfs(OrgChart root, OrgChart target, Stack<OrgChart> parentStack) {
        if (root == null) return false;

        parentStack.add(root);

        if (equals(root, target)) {
            return true;
        }

        for (OrgChart children: root.directReports) {
            boolean found = dfs(children, target, parentStack);
            if (found) return true;
        }

        parentStack.pop();

        return false;
    }

    private static boolean equals(OrgChart o1, OrgChart o2) {
        return o1.name == o2.name;
    }


//    static class OrgInfo {
//        private int managersCount = 0;
//        pr
//    }


    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}
