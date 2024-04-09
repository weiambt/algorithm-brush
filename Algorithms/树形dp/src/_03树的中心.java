import java.util.*;

/*
    2023/2/3 23:19
    @author ZW
    Project Name:eclipse_worksapce

     1073. 树的中心

     给定一棵树，树中包含 n 个结点（编号1~n）和 n?1 条无向边，每条边都有一个权值。

        请你在树中找到一个点，使得该点到树中其他结点的最远距离最近。
*/
public class _03树的中心 {
    static int N = 10100,M = 2*N;
    static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
    static int ans = 0x3f3f3f3f,idx;
    static int[] d1 = new int[N],d2 = new int[N],p1 = new int[N];//向下的最大长度、第二大长度、
    //p1[i] = j 表示节点i的d1[i]时的路径经过节点j
    static int[] up = new int[N];//向上的最大值
    static void add(int a,int b,int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    public static void main(String[] args) {
        Arrays.fill(h,-1);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a,b,c);
            add(b,a,c);
        }
        //
        dfs_down(1,-1);
        dfs_up(1,-1);

        for (int i = 1; i <= n ; i++) {
            ans = Math.min(ans,Math.max(up[i],d1[i]));
        }
        System.out.println(ans);
    }

    //计算向下的最长距离（可无返回值）
    //先递归，再计算。（算向下最长路径时是用子节点的信息更新父节点）
    static int dfs_down(int u, int fa) {
        for(int i =h[u];i!=-1;i=ne[i]){
            int j = e[i];
            if(j==fa) continue;
            int d = dfs_down(j,u) + w[i];
            if(d>=d1[u]){
                d2[u] = d1[u];
                d1[u] = d;
                p1[u] = j;//向下最大距离是经过j的路径
            }else if(d>d2[u])
                d2[u] = d;
        }
        return d1[u];
    }

    //计算节点向上的最长距离
    //先计算，再递归。（算向上最长路径时是用父节点的信息更新子节点）
    static void dfs_up(int u, int fa) {
        for(int i=h[u];i!=-1;i = ne[i]){
            int j = e[i];
            if(j==fa) continue;
            if(j==p1[u]){
                up[j] = Math.max(up[u],d2[u])+w[i];
            }else{
                up[j] = Math.max(up[u],d1[u])+w[i];
            }
            dfs_up(j,u);
        }

    }
}
