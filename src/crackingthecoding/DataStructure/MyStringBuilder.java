package crackingthecoding.DataStructure;

public class MyStringBuilder {
    private char[] arr;
    private int lastPos;

    public MyStringBuilder() {
        arr = new char[2];
        lastPos = 0;
    }

    public MyStringBuilder(int capacity) {
        arr = new char[capacity];
        lastPos = 0;
    }

    public MyStringBuilder append(String s) {
        for (char c: s.toCharArray()) {
            insertChar(c);
        }
        return this;
    }

    public MyStringBuilder append(char c) {
        insertChar(c);
        return this;
    }

    public String toString() {
        return new String(arr);
    }

    private void insertChar(char c) {
        if (lastPos + 1 > arr.length) {
            doubleCapacity();
        }
        arr[lastPos++] = c;
    }

    private void doubleCapacity() {
        int newCapacity = arr.length * 2;
        if (newCapacity >= Integer.MAX_VALUE) {
          newCapacity = Integer.MAX_VALUE;
        }
        char[] newArr = new char[newCapacity];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        this.arr = newArr;
    }

}
