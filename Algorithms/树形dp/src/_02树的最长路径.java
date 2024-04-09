import java.util.*;

/*
    2023/2/2 13:21
    @author ZW
    Project Name:eclipse_worksapce
     
*/
public class _02�����·�� {
    static int N = 20100;
    static int[] h = new int[N],e = new int[N],ne = new int[N],w = new int[N];
    static int idx,ans,n;
    static void add(int a,int b,int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
   }
   //���ظ��ڵ�u�µ��·�����ȣ�father��u�ĸ��ڵ�
   static int dfs(int u,int father){
        int dist=0,d1=0,d2=0;

        for(int i=h[u];i!=-1;i=ne[i]){
            int j = e[i];
            if(j==father) continue;
            int wei = dfs(j,u) + w[i];
            if(wei>d1){
                d2 = d1;
                d1 = wei;
            }else if(wei>d2){
                d2 = wei;
            }
            dist = Math.max(dist,wei);
        }
       ans = Math.max(ans,d1+d2);

       return dist;
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(h,-1);
        for (int i = 0 ; i < n - 1 ; i ++ ){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a,b,c);   //��Ϊ������ߣ�������������ֱ��һ��
            add(b,a,c);
        }
        //�Խڵ�1��Ϊ��������������
        dfs(1,-1);
        System.out.println(ans);
    }
}
