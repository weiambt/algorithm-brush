import java.util.*;

/*
    2023/2/3 23:19
    @author ZW
    Project Name:eclipse_worksapce

     1073. ��������

     ����һ���������а��� n ����㣨���1~n���� n?1 ������ߣ�ÿ���߶���һ��Ȩֵ��

        �����������ҵ�һ���㣬ʹ�øõ㵽��������������Զ���������
*/
public class _03�������� {
    static int N = 10100,M = 2*N;
    static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
    static int ans = 0x3f3f3f3f,idx;
    static int[] d1 = new int[N],d2 = new int[N],p1 = new int[N];//���µ���󳤶ȡ��ڶ��󳤶ȡ�
    //p1[i] = j ��ʾ�ڵ�i��d1[i]ʱ��·�������ڵ�j
    static int[] up = new int[N];//���ϵ����ֵ
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

    //�������µ�����루���޷���ֵ��
    //�ȵݹ飬�ټ��㡣���������·��ʱ�����ӽڵ����Ϣ���¸��ڵ㣩
    static int dfs_down(int u, int fa) {
        for(int i =h[u];i!=-1;i=ne[i]){
            int j = e[i];
            if(j==fa) continue;
            int d = dfs_down(j,u) + w[i];
            if(d>=d1[u]){
                d2[u] = d1[u];
                d1[u] = d;
                p1[u] = j;//�����������Ǿ���j��·��
            }else if(d>d2[u])
                d2[u] = d;
        }
        return d1[u];
    }

    //����ڵ����ϵ������
    //�ȼ��㣬�ٵݹ顣���������·��ʱ���ø��ڵ����Ϣ�����ӽڵ㣩
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
