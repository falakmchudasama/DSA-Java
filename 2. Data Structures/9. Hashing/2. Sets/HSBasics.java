import java.util.HashSet;
import java.util.Iterator;

public class HSBasics {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("New York");
        set.add("Miami");
        set.add("Los Angeles");
        set.add("Las Vegas");
        set.add("San Francisco");
        set.add("Dallas");
        set.add("New Jersey");

        Iterator<String> i = set.iterator();
        while(i.hasNext()){
            System.out.println( i.next());
        }
    }
}
