/*
    2023/1/23 21:08
    @author ZW
    Project Name:eclipse_worksapce

    数字游戏 II （数位dp）

     某人又命名了一种取模数，这种数字必须满足各位数字之和 mod N 为 0。
        现在大家又要玩游戏了，指定一个整数闭区间 [a.b]，问这个区间内有多少个取模数。
*/
import java.util.*;
public class _05数字游戏II {
    static int mod;
    static int N = 12;
    //dp[i][j][k]表示共i位，最高位是j，各位之和的余数是k（和的模是k）的方案数
    static int[][][] dp = new int[N][10][105];

    static void init(){
        //dp清空
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j],0);
            }
        }

        //处理位数是1的情况
        for (int i = 0; i < 10; i++) {
            dp[1][i][i%mod] ++;
        }

        //处理位数2~n的情况
        for (int i = 2; i < N; i++) {//位数
            for (int j = 0; j < 10; j++) {//首位
                for (int k = 0; k < mod; k++) {//和的模
                    for (int x = 0; x < 10; x++) {//首位的下一位是x
                        dp[i][j][k] += dp[i-1][x][solveMod(k-j,mod)];
                    }
                }
            }
        }
    }

    static int count(int n){
        if(n==0) return 1;
        ArrayList<Integer> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%10);
            n /= 10;
        }
        n = nums.size();
        int res = 0;
        int last = 0;//前面位数的数字和
        for (int i = n-1; i >= 0 ; i--) {
            int x = nums.get(i);
            //枚举当前位<x的所有情况
            for (int j = 0; j < x; j++) {
                //abcXdef
                //因为[last + sum(Xdef) ]%mod = 0
                //所以 sum(Xdef)%mod = (-last)%mod
                res += dp[i+1][j][solveMod(-last,mod)];
            }
            last += x;

            if(i==0 && last%mod==0) res++;
        }
        return res;
    }

    //因为java、c++运算中正数取模之后结果是正数，负数取模之后是负数，
    //所以我要让他们等于正数，就让模完之后在加一个P在% 一个P == 没有操作，
    //就变成正数
    private static int solveMod(int a, int mod) {
        return (a%mod + mod)%mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            mod = sc.nextInt();
            init();
            System.out.println(count(b)-count(a-1));
        }
    }
}
