import java.util.LinkedHashSet;
import java.util.TreeSet;

public class LHSandTS {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        TreeSet<Integer> ts = new TreeSet<>();
        
        lhs.add(8);
        lhs.add(7);
        lhs.add(1);
        lhs.add(4);
        lhs.add(3);

        ts.add(8);
        ts.add(7);
        ts.add(1);
        ts.add(4);
        ts.add(3);

        System.out.println(lhs);
        System.out.println(ts);
    }
}
