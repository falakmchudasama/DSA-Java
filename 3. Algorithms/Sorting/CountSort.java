public class CountSort {
    public static void countSort(int[] array){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            max = Math.max(max, array[i]);
        }

        int[] countingArray = new int[max+1];

        for(int i = 0; i < array.length; i++){
            countingArray[array[i]]++;
        }

        int j = 0;
        for(int i = 0; i < array.length; i++){
            while(countingArray[i] > 0){
                array[j] = i;
                j++;
                countingArray[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {9,1,4,7,3,-1,0,5,8,-1,6};
        countSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
