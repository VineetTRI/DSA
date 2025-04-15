
public class ZeroOneKnapsackTabulation {
    public static int Knapsack(int[] val,int[] weight,int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            int v = val[i-1];
            int w = weight[i-1];
            for(int j = 1;j<=W;j++){
                if(w<=j){ // valid
                    int include = v + dp[i-1][j-w];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include,exclude);
                }
                else{//invalid
                    int exclude = dp[i-1][j];
                    dp[i][j] = exclude;
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] w = {2,5,1,3,4};
        int W=7;
        System.out.println(Knapsack(val,w,W));
    }
}
