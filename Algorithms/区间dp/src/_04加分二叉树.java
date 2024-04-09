/*
    2023/2/1 12:54
    @author ZW
    Project Name:eclipse_worksapce
     
*/
import java.util.*;
public class _04加分二叉树 {
    static int N = 35;
    static int[] w = new int[N];
    static int[][] dp = new int[N][N];
    //path存放区间[l,r]的根节点（分界点）
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
                    path[l][r] = l;//根节点是自己
                }
                else{
                    for (int k = l; k <= r; k++) {//枚举根节点
                        int left = k==l?1:dp[l][k-1];//特判左子空树
                        int right = k==r?1:dp[k+1][r];//特判右子空树
                        int weight = left*right+w[k];
                        if(dp[l][r] < weight){//因为k是升序的，所以保证这里保证相等最大值的第一个位置
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

    //递归输出先序遍历结果
    static void dfs(int l,int r){
        if(l>r) return;
        System.out.print(path[l][r]+" ");
        dfs(l,path[l][r]-1);
        dfs(path[l][r]+1,r);
    }


}
