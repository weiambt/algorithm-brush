/*
    2023/1/22 22:11
    @author ZW
    Project Name:eclipse_worksapce

    数字游戏：数位dp
     某人命名了一种不降数，这种数字必须满足从左到右各位数字呈非下降关系，如 123，446。
        现在大家决定玩一个游戏，指定一个整数闭区间 [a,b]，问这个区间内有多少个不降数。

    使用线性规划预处理一个数组dp。
*/
import java.util.*;
public class _03数字游戏 {
    static int N = 36;
    //dp[i][j]表示一共有i位，且最高位是j的不降数的个数
    static int[][] dp = new int[N][N];

    static int count(int n){
        if(n==0) return 1;
        ArrayList<Integer> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%10);
            n/=10;
        }
        n = nums.size();
        int res = 0;
        int last = 0;//前一位
        for(int i=n-1;i>=0;i--){
            int x = nums.get(i);
            for (int j = last; j < x; j++) {
                res += dp[i+1][j];
            }
            if(x<last) break;//右子树不存在
            last = x;
            if(i==0) res++;

        }
        return res;
    }
    //使用动态规划初始化数组
    static void init(){
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < N ; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        init();
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(count(b)-count(a-1));
        }
    }

}
