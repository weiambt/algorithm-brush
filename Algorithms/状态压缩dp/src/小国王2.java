import java.util.ArrayList;
import java.util.Scanner;


/*
    2023/1/9 23:11
    @author ZW
    Project Name:eclipse_worksapce

    状态压缩dp
    AcWing 1064. 小国王
    参考代码：https://www.acwing.com/activity/content/code/content/3048274/


    答案的计算方法不同，

*/
public class 小国王2 {

    static int N = 12,M = 1<<10,K = 110;
    static int n,k;
    //state存放所有合法的状态（满足没有相邻的1）
    static ArrayList<Integer> state = new ArrayList<>();
    //head存放所有合法的状态能够连通的所有状态，比如head[a]=b，那么b[0],b[1],...代表状态a的下一行可以是状态b[0],b[1],...
    static ArrayList<Integer>[] head = new ArrayList[M];
    //cnt[i]=j，状态i中1的个数为j
    static int[] cnt = new int[M];
    static long [][][] dp = new long[N][K][M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        //1.初始化判断所有合法状态，并将状态保存到state,并计算1的个数
        for (int i = 0; i < 1<<n; i++) {
            if(check(i)){
                state.add(i);
                cnt[i] = count(i);
            }
        }

        //2.计算每一个状态a，找到所有下一排合法的状态b，存放在head[a]中
        for (int i = 0; i < state.size(); i++) {
            for (int j = 0; j < state.size(); j++) {
                int a = state.get(i);
                int b = state.get(j);

                if( (a&b)==0 && check(a|b)){
                    //(a&b)==0:表示相邻两排同一列不能都是1
                    //check(a|b)：表示相邻两排对角位置不能都是1（理解！！！！！）
                    if(head[i]==null)
                        head[i] = new ArrayList<>();
                    head[i].add(j);
                }
            }
        }
        dp[0][0][0]=1;

        //3.开始dp，四重循环
        for (int i = 1; i <= n+1; i++) {//行，多加一行
            for (int j = 0; j <= k; j++) {//国王个数
                for (int a = 0; a < state.size(); a++) {//当前这一层的状态的下标：a
                    for (int b : head[a]) {
                        int cntt = cnt[state.get(a)];//这一层国王的个数
                        if(j>=cntt){
                            dp[i][j][a] += dp[i-1][j-cntt][b];
                        }
                    }
                }

            }
        }

        System.out.println(dp[n+1][k][0]);
    }

    /*
        检查状态state是否满足：无相邻的1.
    */
    static boolean check(int state){
        for (int i = 0; i < n; i++) {
            if( (state>>i&1)==1 && (state>>(i+1)&1)==1 ){
                return false;
            }
        }
        return true;
    }

    /*
    计算state中1的个数
     */
     static int count(int state) {
         int res=0;
         for (int i = 0; i < n; i++) {
             if((state>>i&1)==1)
                res ++ ;
         }
         return res;
    }


}
