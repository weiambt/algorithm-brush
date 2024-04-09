import java.util.*;
public class _01没有上司的舞会 {
    static int N = 6060;
    static int[] happy = new int[N];
    static int[][] dp = new int[N][2];//dp[i][j]表示以i为树根的子树中，j表示是否选择i的方案的最大值
    static int[] h = new int[N],e = new int[N],ne = new int[N];//邻接表
    static int idx;
    static int[] has_father = new int[N];//==1表示该节点存在父节点
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n ; i++) {
            happy[i] = sc.nextInt();
        }
        Arrays.fill(h,-1);
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(b,a);//b是a的上司
            has_father[a] = 1;
        }

        //找到根节点（没有父节点的节点）
        int root = 1;
        while(has_father[root]==1)
            root++;
        dfs(root);
        System.out.println(Math.max(dp[root][0],dp[root][1]));
    }

    static void dfs(int root) {
        //dp[root][0] = 0;
        dp[root][1] = happy[root];
        for(int i = h[root];i!=-1;i = ne[i]){
            int j = e[i];
            dfs(j);//递归子树
            dp[root][0] += Math.max(dp[j][0],dp[j][1]);
            dp[root][1] += dp[j][0];
        }
    }
}