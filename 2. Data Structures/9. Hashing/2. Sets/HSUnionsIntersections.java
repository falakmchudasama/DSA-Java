import java.util.HashSet;

public class HSUnionsIntersections {
    // Union
    public static HashSet<Integer> union(int[] array1, int[] array2){
        HashSet<Integer> result = new HashSet<>();
        for (Integer i : array1) {
            result.add(i);
        }
        for (Integer i : array2) {
            result.add(i);
        }
        return result;
    }

    // Intersection
    private static HashSet<Integer> helper(int[] arr1, int[] arr2){
        HashSet<Integer> temp = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for(int i = 0; i < arr1.length; i++){
            temp.add(arr1[i]);
        }

        for(int i = 0; i < arr2.length; i++){
            if(temp.contains(arr2[i])){
                result.add(arr2[i]);
            }
        }
        return result;
    }
    public static HashSet<Integer> intersection(int[] array1, int[] array2){
        if(array1.length >= array2.length){
            return helper(array1, array2);
        }
        else{
            return helper(array2, array1);
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};

        HashSet<Integer> result1 = union(arr1, arr2);
        HashSet<Integer> result2 = intersection(arr1, arr2);

        System.out.println(result1);
        System.out.println(result2);
    }
}
