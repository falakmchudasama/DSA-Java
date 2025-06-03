import java.util.Arrays;

public class MinAbsoluteDiff {
    public static int minAbsoluteDiff(int array1[], int array2[]){
        int sum = 0;
        for(int i = 0; i < array1.length; i++){
            sum += Math.abs( array1[i] - array2[i] );
        }
        return sum;
    }
    public static void main(String[] args) {
        int array1[] = {4,1,8,7};
        int array2[] = {2,3,6,5};

        Arrays.sort(array1);
        Arrays.sort(array2);

        int result = minAbsoluteDiff(array1, array2);
        System.out.println(result);
    }
}
