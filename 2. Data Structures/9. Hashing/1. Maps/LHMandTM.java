import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LHMandTM {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        TreeMap<String, Integer> ts = new TreeMap<>();

        lhm.put("Los Santos", 9);
        lhm.put("Vice City", 10);
        lhm.put("Liberty City", 8);

        ts.put("Los Santos", 9);
        ts.put("Vice City", 10);
        ts.put("Liberty City", 8);

        System.out.println(lhm);
        System.out.println(ts);
    }
}
