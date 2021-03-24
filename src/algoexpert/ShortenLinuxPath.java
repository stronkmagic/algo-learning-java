package algoexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortenLinuxPath {
    public static void main(String[] args) {
        System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz"));
        System.out.println(shortenPath("/////"));
        System.out.println(shortenPath("/../../.."));
        System.out.println(shortenPath("/./././/../../.."));
        System.out.println(shortenPath("foo/bar"));
        System.out.println(shortenPath("../../bar/baz"));
        System.out.println(shortenPath("../../../this////one/./../../is/../../going/../../to/be/./././../../../just/eight/double/dots/../../../../../../foo"));
        System.out.println(shortenPath("/../../foo/../../bar/baz"));
    }

    public static String shortenPath(String path) {
        // Write your code here;
        boolean isRoot = path.charAt(0) == '/';

        //Stack<String> stack = new Stack<>();
        List<String> stack = new ArrayList<>();
        String[] paths = path.split("/");

        for (String p: paths) {
            if (p.equals("..")) {
                if (!stack.isEmpty() && !stack.get(stack.size() - 1).equals("..")) {
                    stack.remove(stack.size() - 1);
                } else if (!isRoot) {
                    stack.add("..");
                }

            } else if (p.equals(".")) {
                continue;
            } else {
                if (!p.isEmpty()) stack.add(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String pathShort:stack) {
            sb.append("/").append(pathShort);
        }

        String res = sb.toString();
        if (res.isEmpty() && isRoot) return "/";

        return isRoot ? res : res.substring(1);
    }
}
