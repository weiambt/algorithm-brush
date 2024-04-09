/*
    2023/2/4 20:52
    @author ZW
    Project Name:eclipse_worksapce
     
*/
import java.util.*;
public class _04数字转换 {
    static int N = 51000,M = 2*N;
    static int[] h = new int[N],ne = new int[M],e = new int[M];
    static int idx;
    static int[] st = new int[N];//记录是否访问过,没访问过就是新的一棵树
    static int[] sum = new  int[N];
    static int ans = 0;
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    //返回向下的最长边长
    static int dfs(int u){
        int d1 = 0,d2 = 0;
        st[u] = 1;//把这颗树上的所有节点全部标记，那么剩下的节点就是其他树上的
        for(int i=h[u];i!=-1;i=ne[i]){
            int j = e[i];
            int d = dfs(j)+1;
            if(d>=d1){
                d2 = d1;
                d1 = d;
            }else if(d>d2)
                d2 = d;
        }
        ans = Math.max(ans,d1+d2);

        return d1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Arrays.fill(h,-1);
        //计算约数之和（难点）
        //i对《i的倍数的约数和》贡献值就是i
        for(int i=1;i<=n;i++){//枚举1~n
            for(int j =i+i;j<=n;j+=i){//枚举i的倍数
                sum[j] += i;
            }
        }

        //建图，因为多个数的约数和可能是同一个，所以要以约束和作为父节点
        for (int i = 1; i <= n ; i++) {
            if(sum[i]<i){
                add(sum[i],i);
            }
        }
        //遍历整个森林
        for (int i = 1; i <= n ; i++) {
            if(st[i]==0)//如果没访问过，就是一棵新树
                dfs(i);
        }
        System.out.println(ans);
    }
}

