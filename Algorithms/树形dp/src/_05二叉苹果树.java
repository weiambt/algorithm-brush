// import java.util.Arrays;
// import java.util.Scanner;
//
// /*
//     2023/2/4 20:52
//     @author ZW
//     Project Name:eclipse_worksapce
//
// */
// public class _05二叉苹果树 {
//     static int N = 110, M = 2*N;
//     static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
//     static int idx;
//     static void add(int a,int b,int c){
//         e[idx] = b;
//         w[idx] = c;
//         ne[idx] = h[a];
//         h[a] = idx++;
//     }
//     //返回根节点为u的树向下的最大长度，q是边的长度
//     static int dfs(int u,int fa,int q){
//         if(q==0) return 0;
//         int dist=0;
//         for(int i=h[u];i!=-1;i=ne[i]){
//             int j = e[i];
//             if(j==fa) continue;
//             int d = dfs(j,u,q-1) + w[i];
//             dist = Math.max(dist,d);
//         }
//         return dist;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         Arrays.fill(h,-1);
//         int n = sc.nextInt();
//         int q = sc.nextInt();
//         for (int i = 0; i < n - 1; i++) {
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             int c = sc.nextInt();
//             add(a,b,c);
//             add(b,a,c);
//         }
//         int ans = dfs(1,-1,q);
//         System.out.println(ans);
//     }
// }
