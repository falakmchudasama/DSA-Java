import java.util.HashSet;

public class HSCountElements {
    public static int countElements(int[] array){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            set.add(array[i]);
        }
        return set.size();
    }
    public static void main(String[] args) {
        int[] array = {4,5,6,7,8,1,2,3,5,4,7,8,6,2};
        int result = countElements(array);
        System.out.println(result);
    }
}
