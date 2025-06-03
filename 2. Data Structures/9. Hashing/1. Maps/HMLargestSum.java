import java.util.HashMap;
import java.util.ArrayList;

public class HMLargestSum {
    public static ArrayList<Integer> largestSubArray(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> uniqueMap = new HashMap<>();
        HashMap<Integer, Integer> duplicateMap = new HashMap<>();
        int sum = 0;
        int endingPoint = Integer.MAX_VALUE;
        int keyToFind = 0;

        for(int j = 0; j < arr.length; j++){
            sum += arr[j];
            if(!uniqueMap.containsKey(sum)){
                uniqueMap.put(sum, j);
            }
            else{
                endingPoint = Math.min(endingPoint, j - uniqueMap.get(sum));
                keyToFind = sum;
                duplicateMap.put(sum, endingPoint);
            }
        }
        int startingPoint = Integer.MAX_VALUE;
        for (Integer key : uniqueMap.keySet()) {
            if(key == keyToFind){
                startingPoint = Math.min(startingPoint, uniqueMap.get(key));
            }
        }
        for(int i = startingPoint+1; i <= endingPoint; i++){
            result.add(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {2,9,7,-1,-5,-7,-3,-3};
        ArrayList<Integer> subArray = largestSubArray(array);
        System.out.println(subArray);
    }
}
