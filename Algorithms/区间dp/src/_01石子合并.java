import java.util.*;

/*
    2023/1/10 22:01
    @author ZW
    Project Name:eclipse_worksapce

*/
public class _01石子合并 {
    static int[] sum = new int[305];
    static long[][] dp = new long[305][305];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            sum[i] = sc.nextInt() + sum[i-1];
            dp[i][i]=0;
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 1; l + len -1 <= n; l++) {
                int r = l + len - 1;
                dp[l][r] = 0x3f3f3f3f;
                for (int k = l; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r],dp[l][k]+dp[k+1][r]+sum[r]-sum[l-1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
