/*
    2023/1/24 22:20
    @author ZW
    Project Name:eclipse_worksapce
     
*/
import java.util.*;
public class _06不要62 {
    static int N = 10;
    //dp[i][j]表示共i位，最高位是j的吉利车牌的数量
    static int[][] dp = new int[N][10];
    static void init(){
        for (int i = 0; i < 10; i++) {
            if(i!=4)
                dp[1][i] = 1;
        }
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==4) continue;
                for (int k = 0; k < 10; k++) {
                    if(k==4 || (j==6 && k==2)) continue;
                    dp[i][j] += dp[i-1][k];
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
        int last = 0;
        for (int i = n-1; i >= 0; i--) {
            int x  = nums.get(i);
            for (int j = 0; j < x; j++) {
                if(j==4 || (last==6 && j == 2))
                    continue;
                res += dp[i+1][j];
            }
            if(x==4 ||  (last==6 && x == 2)) break;
            last = x;

            if(i==0)
                res++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(n==0 && m==0) break;
            init();
            System.out.println(count(m)-count(n-1));
        }
    }
}
