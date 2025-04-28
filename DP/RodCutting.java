public class RodCutting {
    public static int findMaxProfit(int[] len,int[] price,int rodLen){
        //Same as Unbounded Knapsack
        int n = len.length;
        int[][] dp = new int[n+1][rodLen+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=rodLen;j++){
                //include
                if(len[i-1]<=j){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-len[i-1]],dp[i-1][j]);
                }
                //exclude
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rodLen];
    }
    public static void main(String[] args) {
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        int rodLen = 8;
        System.out.println(findMaxProfit(length,price,rodLen));
    }
}
