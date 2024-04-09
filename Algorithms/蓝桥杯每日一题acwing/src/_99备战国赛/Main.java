package _99备战国赛;


import java.util.*;
import java.util.Map.Entry;
import java.math.*;
import java.io.*;

public class Main {
	static int INF = 0x3f3f3f3f;
	static int N = 10100 , M = 30000;
	static int n,m,qq,k;
	static int[] d1 = new int[N],p1 = new int[N],d2 = new int[N],up = new int[N];
	static String[] arr = new String[N];
	static int[][] dp = new int[100][100];
	static int[] h = new int[N],w = new int[M],e = new int[M],ne = new int[M];
	static int idx;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static void add(int a,int b,int c) {
		e[idx] = b;
		ne[idx] = h[a];
		w[idx] = c;
		h[a] = idx++;
	}
	
	static int ans = 0;
	static char[] a,b;
	static int sz1,sz2;
	static void solve() {
		for(int i=1;i<=sz1;i++) {
			for(int j=1;j<=sz2;j++) {
				dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
				if(a[i]==b[j])
					dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
				else 
					dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(h,-1);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = " "+sc.next();
		}
		while(m-->0) {
			b = (" " + sc.next()).toCharArray();
			int maxCnt = sc.nextInt();
			int ans = 0;
			for(int i=1;i<=n;i++) {
				a = arr[i].toCharArray();
				sz1 = a.length-1;
				sz2 = b.length-1;
				solve();
				
				if(dp[sz1][sz2]<=maxCnt)
					ans++;
			}
			System.out.println(ans);
		}
		
		
		
	}
}
class PII{
	int x,y;
	PII(int val,int v){
		this.x = val;
		this.y = v;
	}
}


