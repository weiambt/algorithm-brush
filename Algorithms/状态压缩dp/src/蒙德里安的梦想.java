import java.util.*;

/*
    2023/1/10 19:19
    @author ZW
    Project Name:eclipse_worksapce

   蒙德里安的梦想：基础版AC代码（未优化）
     
*/
public class 蒙德里安的梦想 {

    static int N = 12, M= 1<<12;
    static long[][] dp = new long[N][M];// 第一维表示列， 第二维表示可能的状态
    static boolean[] st = new boolean[M];//存储每种状态是否有奇数个连续的0，如果奇数个0是无效状态，如果是偶数个零置为true。

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(n==0 && m==0) break;

            //1.预处理所有合法的状态：连续0的个数是偶数
            //对于每种状态，先预处理每列不能有奇数个连续的0
            for (int i = 0; i < 1 << n; i++) {//枚举状态
                int cnt=0;
                boolean flag = true;
                //判断该列能否放竖着的长方形：判断所有连续0的个数是否是偶数
                for (int j = 0; j < n; j++) {//枚举这个状态下所有的二进制
                    if((i>>j&1)==1){//这一位是1
                        if(cnt%2==1){//计算前面的连续0的个数
                            flag = false;
                            break;
                        }
                    }else
                        cnt++;
                }
                if(cnt%2==1) //还有最后一组要特判
                    flag = false;
                st[i] = flag;
            }
            //2.dp
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i],0);// 因为有多组数据，防止上一组数据的干扰，所以清零
            }
            dp[0][0]=1;// 什么都没有时候，空着表示一种方案

            for (int i = 1; i <= m; i++) {//枚举列数：第i列合法范围是(0~m-1列)
                for (int j = 0; j < 1<<n; j++) {//第i列的状态
                    for (int k = 0; k < 1<<n; k++) {//枚举第i-1列的状态,（这里可能会导致时间复杂度高，所以在前面可以优化）
                        //1、j跟k没有相交，2、i-1列的0的个数是不是偶数
                        if((j&k)==0 && st[j|k])
                            dp[i][j]+=dp[i-1][k];
                    }
                }
            }
            //答案是dp[m][0]，表示前m-1列都处理完，并且第m-1列没有伸出来的所有方案数。
            System.out.println(dp[m][0]);
        }



    }
}
