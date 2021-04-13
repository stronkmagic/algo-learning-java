package leetcode.classdesign.nestedInteger;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerImp implements NestedInteger {

    List<NestedInteger> list;
    Integer val;

    public NestedIntegerImp(List<NestedInteger> list){
        this.list = list;
    }

    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.val = num;
    }

    public NestedIntegerImp(Integer integer){
        this.val = integer;
    }

    public NestedIntegerImp() {
        this.list = new ArrayList();
    }

    @Override
    public boolean isInteger() {
        return val != null;
    }

    @Override
    public Integer getInteger() {
        return val;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
