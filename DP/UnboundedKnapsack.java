public class UnboundedKnapsack {
    public static int Knapsack(int[] val,int[] weight,int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        // no need of initialization in java
        for(int i=1;i<=n;i++){
            int v = val[i-1];
            int w = weight[i-1];
            for(int j=1;j<=W;j++){
                //valid
                if(w<=j){
                    int include = v + dp[i][j-w];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include,exclude);
                }
                //invalid
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] w = {2,5,1,3,4};
        int W=7;
        System.out.println("Max Profit = "+Knapsack(val,w,W));
    }
}
