/*
    2023/2/1 12:54
    @author ZW
    Project Name:eclipse_worksapce
     
*/
import java.util.*;
public class _04�ӷֶ����� {
    static int N = 35;
    static int[] w = new int[N];
    static int[][] dp = new int[N][N];
    //path�������[l,r]�ĸ��ڵ㣨�ֽ�㣩
    static int[][] path = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n ; i++) {
            w[i] = sc.nextInt();
        }

        for (int len = 1; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len -1;
                if(len==1){
                    dp[l][r] = w[l];
                    path[l][r] = l;//���ڵ����Լ�
                }
                else{
                    for (int k = l; k <= r; k++) {//ö�ٸ��ڵ�
                        int left = k==l?1:dp[l][k-1];//�������ӿ���
                        int right = k==r?1:dp[k+1][r];//�������ӿ���
                        int weight = left*right+w[k];
                        if(dp[l][r] < weight){//��Ϊk������ģ����Ա�֤���ﱣ֤������ֵ�ĵ�һ��λ��
                            dp[l][r] = weight;
                            path[l][r] = k;
                        }
                    }
                }
            }
        }
        System.out.println(dp[1][n]);
        dfs(1,n);
    }

    //�ݹ��������������
    static void dfs(int l,int r){
        if(l>r) return;
        System.out.print(path[l][r]+" ");
        dfs(l,path[l][r]-1);
        dfs(path[l][r]+1,r);
    }


}
