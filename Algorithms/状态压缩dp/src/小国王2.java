import java.util.ArrayList;
import java.util.Scanner;


/*
    2023/1/9 23:11
    @author ZW
    Project Name:eclipse_worksapce

    ״̬ѹ��dp
    AcWing 1064. С����
    �ο����룺https://www.acwing.com/activity/content/code/content/3048274/


    �𰸵ļ��㷽����ͬ��

*/
public class С����2 {

    static int N = 12,M = 1<<10,K = 110;
    static int n,k;
    //state������кϷ���״̬������û�����ڵ�1��
    static ArrayList<Integer> state = new ArrayList<>();
    //head������кϷ���״̬�ܹ���ͨ������״̬������head[a]=b����ôb[0],b[1],...����״̬a����һ�п�����״̬b[0],b[1],...
    static ArrayList<Integer>[] head = new ArrayList[M];
    //cnt[i]=j��״̬i��1�ĸ���Ϊj
    static int[] cnt = new int[M];
    static long [][][] dp = new long[N][K][M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        //1.��ʼ���ж����кϷ�״̬������״̬���浽state,������1�ĸ���
        for (int i = 0; i < 1<<n; i++) {
            if(check(i)){
                state.add(i);
                cnt[i] = count(i);
            }
        }

        //2.����ÿһ��״̬a���ҵ�������һ�źϷ���״̬b�������head[a]��
        for (int i = 0; i < state.size(); i++) {
            for (int j = 0; j < state.size(); j++) {
                int a = state.get(i);
                int b = state.get(j);

                if( (a&b)==0 && check(a|b)){
                    //(a&b)==0:��ʾ��������ͬһ�в��ܶ���1
                    //check(a|b)����ʾ�������ŶԽ�λ�ò��ܶ���1����⣡����������
                    if(head[i]==null)
                        head[i] = new ArrayList<>();
                    head[i].add(j);
                }
            }
        }
        dp[0][0][0]=1;

        //3.��ʼdp������ѭ��
        for (int i = 1; i <= n+1; i++) {//�У����һ��
            for (int j = 0; j <= k; j++) {//��������
                for (int a = 0; a < state.size(); a++) {//��ǰ��һ���״̬���±꣺a
                    for (int b : head[a]) {
                        int cntt = cnt[state.get(a)];//��һ������ĸ���
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
        ���״̬state�Ƿ����㣺�����ڵ�1.
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
    ����state��1�ĸ���
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
