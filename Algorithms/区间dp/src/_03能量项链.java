import java.util.Scanner;

/*
    2023/1/31 23:28
    @author ZW
    Project Name:eclipse_worksapce
     
*/
public class _03能量项链 {
    static int[] w = new int[220];
    static int[][] dp = new int[220][220];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            w[i+n] = w[i];
        }

        for (int len = 3; len < 2*n; len++) {
            for (int l = 0; l + len -1 < n*2; l++) {
                int r  = l + len - 1;
                for (int k = l+1; k < r; k++) {
                    dp[l][r] += Math.max(dp[l][r],dp[l][k] +dp[k][r] + w[l]*w[k]*w[r]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,dp[i][i+n]);//长度是n+1的子链表
        }
        System.out.println(ans);


    }
}
