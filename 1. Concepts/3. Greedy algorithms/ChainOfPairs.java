import java.util.Comparator;
import java.util.Arrays;

public class ChainOfPairs {
    public static int chainOfPairs(int[][] pairs){
        int chainLen = 1;
        int chainEnd = pairs[0][1];

        for(int i = 1; i < pairs.length; i++){
            if(pairs[i][0] > chainEnd){
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        return chainLen;
    }
    public static void main(String[] args) {
        int pair[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};

        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));
        int result = chainOfPairs(pair);

        System.out.println(result);
    }
}
