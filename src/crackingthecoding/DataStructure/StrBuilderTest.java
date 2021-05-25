package crackingthecoding.DataStructure;

public class StrBuilderTest {
    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();
        sb.append("my str");
        sb.append("    ");
        sb.append('c');

        System.out.println(sb.toString());
    }
}
