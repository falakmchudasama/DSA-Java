public class ArrayBacktracking {
    public static void fillElements(int[] array, int i){
        if(i == array.length){
            return;
        }
        array[i] = i+1;
        fillElements(array, i+1);
        array[i] = array[i] - 2; // Backtracking
    }
    public static void main(String[] args) {
        int Array[] = new int[5];
        fillElements(Array, 0);

        for(int i = 0; i < 5; i++){
            System.out.print(Array[i] + " ");
        }
        System.out.println();
    }
}