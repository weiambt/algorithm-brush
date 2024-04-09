/*
    2023/1/23 18:53
    @author ZW
    Project Name:eclipse_worksapce
     
*/
import java.util.*;
public class _04Windy数 {
    static int N = 11;
    //dp[i][j]表示共i位数，最高位是j的Windy数的个数
    static int[][] dp = new int[N][10];

    //初始化dp数组
    static void init(){
        //一位数字都是Windy数
        for (int i = 0; i < 10; i++) {//要包括0
            dp[1][i] = 1;
        }
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if(Math.abs(j-k)>=2)
                        dp[i][j] += dp[i-1][k];
                }
            }
        }
    }
    static int count(int n){
        if(n==0) return 0;
        ArrayList<Integer> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%10);
            n/=10;
        }
        n = nums.size();
        int res = 0;
        int last = -2;
        //统计恰好是n位的情况
        for (int i = n-1; i >= 0 ; i--) {
            int x = nums.get(i);
            //最高位特判（最高位排除前导0）
            for (int j = (i==n-1?1:0); j < x; j++) {
                if(Math.abs(j-last)>=2)
                    res += dp[i+1][j];
            }
            if(Math.abs(x-last)<2) break;
            last = x;
            if(i==0) res++;

        }
        //统计低n位的数字的情况
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 10; j++) {//j要从1开始，排除前导0
                res += dp[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        init();
        System.out.println(count(b)-count(a-1));
    }
}
