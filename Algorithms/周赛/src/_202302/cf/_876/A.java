package _202302.cf._876;
import java.util.*;

public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 1010,M = 2*N;
	static int[] arr = new int[N],vis = new int[N];
	static int n,m;
	static int val(int i,int k) {
		int res = i/k;
		if(i%k!=0)
			res++;
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		while(m-->0) {
			Arrays.fill(vis,0);
			n = sc.nextInt();
			int k = sc.nextInt();
			int ans = 0,last = -1,sum=0;

			for(int i=1;i<=n/2;i++) {
				if(last!=val(i,k)) {
					last = val(i,k);
					sum++;
					vis[n+1-i]=1;
					ans+=2;
					
				}
			}
			if(n%2==1) {
				int idx = n/2+1;
				for(int i=idx;i<=n;i++) {
					last += vis[i];
					int val = val(i,k);
					if(last>val) {
						last = val;
						ans++;
						break;
					}
				}
			}
			System.out.println(ans);
		}
		
	}
}
