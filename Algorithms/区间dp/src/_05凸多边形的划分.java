import java.math.BigInteger;
import java.util.*;

/*
    2023/2/1 13:58
    @author ZW
    Project Name:eclipse_worksapce
     
*/
public class _05凸多边形的划分 {
    //1.普通写法（无法AC）
    // static int N = 60;
    // static int INF = 0x3f3f3f3f;
    // static int[] w = new int[N];
    // static int[][] dp = new int[N][N];
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     for (int i = 1; i <=n ; i++) {
    //         w[i] = sc.nextInt();
    //     }
    //     for (int len = 3; len <= n; len++) {
    //         for (int l = 1; l + len -1 <= n ; l++) {
    //             int r = l + len -1;
    //             dp[l][r] = INF;
    //
    //             for (int k = l+1; k < r; k++) {
    //                 dp[l][r] = Math.min(dp[l][r],dp[l][k]+dp[k][r]+w[l]*w[k]*w[r]);
    //             }
    //
    //         }
    //     }
    //     System.out.println(dp[1][n]);
    // }
    
    //2.高精度写法
    static int N = 60;
    static BigInteger INF = new BigInteger("10000000000000000000000000000000000000");
    static BigInteger[] w = new BigInteger[N];
    static BigInteger[][] dp = new BigInteger[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <=n ; i++) {
            w[i] = sc.nextBigInteger();
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i],new BigInteger("0"));
        }
        for (int len = 3; len <= n; len++) {
            for (int l = 1; l + len -1 <= n ; l++) {
                int r = l + len -1;
                dp[l][r] = INF;

                for (int k = l+1; k < r; k++) {
                    BigInteger t = w[l].multiply(w[k]).multiply(w[r]);
                    dp[l][r] = dp[l][r].min( dp[l][k].add(dp[k][r]).add(t) );
                }

            }
        }
        System.out.println(dp[1][n]);
    }
}
