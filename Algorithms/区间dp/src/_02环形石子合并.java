import java.util.Arrays;
import java.util.Scanner;

/*
    2023/1/25 23:10
    @author ZW
    Project Name:eclipse_worksapce

*/
public class _02环形石子合并 {
    static int N = 410;//双倍长度，否则会报错
    static int[] sum = new int[N];
    static int[][] min = new int[N][N];
    static int[][] max = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            sum[i] =  sc.nextInt();
            sum[i+n] = sum[i];
        }
        for (int i = 1; i <= 2*n ; i++) {
            sum[i] += sum[i-1];
        }
        for (int i = 1; i < N; i++) {//初始化到最大为N
            Arrays.fill(min[i],0x3f3f3f3f);
            Arrays.fill(max[i],-0x3f3f3f3f);
            min[i][i] = 0;//一堆不需要合并，代价是0
            max[i][i] = 0;
        }

        for (int len = 1; len <= n ; len++) {
            for (int l = 1; l + len -1 <= 2*n ; l++) {
                int r = l + len - 1;
                for (int k = l; k < r ; k++) {
                    min[l][r] = Math.min(min[l][r],min[l][k]+min[k+1][r]+sum[r]-sum[l-1]);
                    max[l][r] = Math.max(max[l][r],max[l][k]+max[k+1][r]+sum[r]-sum[l-1]);
                }
            }
        }
        int ansmin = 0x3f3f3f3f,ansmax = -0x3f3f3f3f;
        for (int i = 1; i <= n ; i++) {
            ansmax = Math.max(ansmax,max[i][i+n-1]);
            ansmin = Math.min(ansmin,min[i][i+n-1]);
        }
        System.out.println(ansmin);
        System.out.println(ansmax);
    }
}
