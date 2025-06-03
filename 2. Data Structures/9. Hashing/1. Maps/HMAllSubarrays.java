import java.util.HashMap;

public class HMAllSubarrays {
    public static int allSubarrays(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;

        for(int j = 0; j < arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum-k, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] array = {10,2,-2,-20,10};
        int k = -10;

        int result = allSubarrays(array, k);
        System.out.println(result);
    }
}
