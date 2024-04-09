/*
    2023/2/4 20:52
    @author ZW
    Project Name:eclipse_worksapce
     
*/
import java.util.*;
public class _04����ת�� {
    static int N = 51000,M = 2*N;
    static int[] h = new int[N],ne = new int[M],e = new int[M];
    static int idx;
    static int[] st = new int[N];//��¼�Ƿ���ʹ�,û���ʹ������µ�һ����
    static int[] sum = new  int[N];
    static int ans = 0;
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    //�������µ���߳�
    static int dfs(int u){
        int d1 = 0,d2 = 0;
        st[u] = 1;//��������ϵ����нڵ�ȫ����ǣ���ôʣ�µĽڵ�����������ϵ�
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
        //����Լ��֮�ͣ��ѵ㣩
        //i�ԡ�i�ı�����Լ���͡�����ֵ����i
        for(int i=1;i<=n;i++){//ö��1~n
            for(int j =i+i;j<=n;j+=i){//ö��i�ı���
                sum[j] += i;
            }
        }

        //��ͼ����Ϊ�������Լ���Ϳ�����ͬһ��������Ҫ��Լ������Ϊ���ڵ�
        for (int i = 1; i <= n ; i++) {
            if(sum[i]<i){
                add(sum[i],i);
            }
        }
        //��������ɭ��
        for (int i = 1; i <= n ; i++) {
            if(st[i]==0)//���û���ʹ�������һ������
                dfs(i);
        }
        System.out.println(ans);
    }
}

