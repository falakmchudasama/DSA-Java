public class FractionalKnapSack {
    public static int knapSack(int weight[],int ratios[], int capacity){
        // assuming that ratios array is sorted
        int value = 0;
        for(int i = 0; i < weight.length; i++){
            if(capacity >= weight[i]){
                value += ratios[i] * weight[i];
                capacity -= weight[i];
            }
            else{
                value += ratios[i] * capacity;
                break;
            }
        }
        return value;
    }
    public static void main(String[] args) {
        int weight[] = {10,20,30};
        int value[] = {60,100,120};
        int capacity = 50;

        int ratios[] = new int[weight.length];

        for(int i = 0; i < weight.length; i++){
            ratios[i] = (value[i] / weight[i]);
        }

        int result = knapSack(weight, ratios, capacity);
        System.out.println(result);
    }
}
