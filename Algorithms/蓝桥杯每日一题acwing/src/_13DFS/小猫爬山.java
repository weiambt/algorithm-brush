package _13DFS;
import java.util.*;
import java.math.*;
import java.io.*;

public class Сè��ɽ {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int n,mx,ans = N;
	static long[] sum = new long[N];
	static Integer[] arr = new Integer[N];
	
	//ö�ٵ�u��è����ǰ�Ѿ���cnt����
	static void dfs(int u,int cnt) {
		if(cnt >= ans) return;
		if(u==n+1) {
			ans = cnt;
			return;
		}
		//����1�������Ѿ����ڵĳ�
		for(int i=1;i<=cnt;i++) {
			if(sum[i] + arr[u] <= mx) {
				sum[i] += arr[u];
				dfs(u+1, cnt);
				sum[i] -= arr[u];
			}
		}
		
		//����2���¼�һ����
		sum[cnt+1] = arr[u];
		dfs(u+1, cnt+1);
		sum[cnt+1] = 0;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		mx = sc.nextInt();

		for(int i=1;i<=n;i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr,1,n+1,(a,b)->(b-a));
		
		dfs(1,0);
		System.out.println(ans);
	}
	
}
