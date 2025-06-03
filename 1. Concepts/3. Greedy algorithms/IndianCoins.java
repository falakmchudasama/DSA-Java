public class IndianCoins {
    // Only works with canonical coin system, great india
    public static int indianCoins(int[] currencies, int amount){
        int coins = 0;
        for(int i = currencies.length-1; i >= 0; i--){
            while(currencies[i] <= amount){
                System.out.print(currencies[i] + " ");
                coins++;
                amount -= currencies[i];
            }
        }
        System.out.println();
        return coins;
    }
    public static void main(String[] args) {
        int currency[] = {1,2,5,10,20,50,100,200,500,2000};
        int amount = 1059;
        int result = indianCoins(currency, amount);

        System.out.println(result);
    }
}
