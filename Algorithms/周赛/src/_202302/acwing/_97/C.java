package _202302.acwing._97;
import java.util.*;

public class C {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N],vis = new int[N];
	static int[] h = new int[N],e = new int[M],ne = new int[M];
	static int idx,ans,n,m,cnt2;
	static void add(int a,int b,int c) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static void init() {
		for(int i=1;i<N;i++)
			h[i] = -1;
	}
	static void dfs(int x,int fa,int cnt,int mx) {
		
		for(int i=h[x];i!=-1;i=ne[i]) {
			int j = e[i];
			if(j==fa) continue;
			if(arr[j]==1) {
				dfs(j, x,cnt+1,Math.max(mx, cnt+1));
			}
			else {
				dfs(j, x,0,mx);
			}
		}
		if(vis[x]==1) {
			ans++;
			if(mx > m) 
				cnt2++;
		}
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		init();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=1;i<=n-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			add(a, b, 1);
			add(b, a, 1);
			vis[a]++;
			vis[b]++;
		}
		vis[1] = 0;
//		for(int i=2;i<=n;i++)
//			if(vis[i]!=1)
//				vis[i] = 0;

		if(arr[1]==1) 
			dfs(1, -1, 1, 1);
		else 
			dfs(1,-1,0,0);
		System.out.println(ans-cnt2);
	}
}
