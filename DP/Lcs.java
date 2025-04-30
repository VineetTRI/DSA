import java.util.Arrays;

public class Lcs {
    public static int lcs(String str1,String str2,int n,int m){
        //Base Case
        if(n==0 || m==0){
            return 0;
        }
        else if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs(str1,str2,n-1,m-1)+1;
        }
        else{
            int ans1 = lcs(str1,str2,n-1,m);
            int ans2 = lcs(str1,str2,n,m-1);
            return Math.max(ans1,ans2);
        }
    }
    public static int lcsMemo(String str1,String str2,int n, int m,int[][] dp){
        if(n==0 || m==0){
            return 0;
        }
        else if(dp[n-1][m-1] != -1){
            return dp[n-1][m-1];
        }
        else if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n-1][m-1] = lcsMemo(str1,str2,n-1,m-1,dp) + 1;
            return dp[n-1][m-1];
        }
        else{
            int ans1 = lcsMemo(str1,str2,n-1,m,dp);
            int ans2 = lcsMemo(str1,str2,n,m-1,dp);
            dp[n-1][m-1] = Math.max(ans1,ans2);
            return dp[n-1][m-1];
        }
    }
    public static int lcsTab(String str1,String str2,int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(lcsMemo(str1,str2,str1.length(),str2.length(),dp));
//        System.out.println(lcsTab(str1,str2,str1.length(),str2.length()));

    }
}
