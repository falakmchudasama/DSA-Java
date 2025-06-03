import java.util.Arrays;
import java.util.Comparator;

public class Chocola {
    public static int chocola(Integer[] costV, Integer[] costH){
        int cost = 0;
        int h = 0;
        int v = 0;
        int hPieces = 1;
        int vPieces = 1;

        while(h < costH.length && v < costV.length){
            if(costV[v] <= costH[h]){
                cost += (costH[h] * vPieces);
                hPieces++;
                h++;
            }
            else{
                cost += (costV[v] * hPieces);
                vPieces++;
                v++;
            }
        }

        while(h < costH.length){
            cost += (costH[h] * vPieces);
            h++;
            vPieces++;
        }

        while(v < costV.length){
            cost += (costV[v] * hPieces);
            v++;
            hPieces++;
        }

        return cost;
    }
    public static void main(String[] args) {
        Integer costV[] = {2,1,3,1,4}; // n = 4
        Integer costH[] = {4,1,2}; // m = 6

        Arrays.sort(costH, Comparator.reverseOrder());
        Arrays.sort(costV, Comparator.reverseOrder());

        int result = chocola(costV, costH);

        System.out.println(result);
    }
}
