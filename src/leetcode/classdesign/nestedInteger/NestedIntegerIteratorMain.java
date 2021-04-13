package leetcode.classdesign.nestedInteger;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerIteratorMain {
    public static void main(String[] args) {
        List<NestedInteger> mainList = new ArrayList<>();

        List<NestedInteger> list1 = new ArrayList<>();
        list1.add(new NestedIntegerImp(1));
        list1.add(new NestedIntegerImp(1));

        mainList.add(new NestedIntegerImp(list1));
        mainList.add(new NestedIntegerImp(2));

        mainList.add(new NestedIntegerImp(list1));

        NestedIterator iterator = new NestedIterator(mainList);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
