import java.util.ArrayList;
import java.util.HashMap;

public class HMArrayFrequency {
    public static ArrayList<Integer> countNumbers(int[] array){
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = array.length / 3;

        for(int i = 0; i < array.length; i++){
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if(map.get(key) > size){
                result.add(key);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int array[] = {1,3,2,5,1,3,1,5,1};
        ArrayList<Integer> result = countNumbers(array);
        System.out.println(result);
    }
}
