package _99备战国赛;

import java.util.*;
import java.io.*;
import java.math.*;

public class 数位dp {
	static int INF = 0x3f3f3f3f;
	static int N = 101,M = 2*N;
	static int[] arr = new int[N];
	static int[][] dp = new int[N][N];
	static int n,m;
	static long ans;
	static void init() {
		//dp[i][j]表示长度是i，第一个是j的合法方案数
		//初始化
		for(int i=0;i<=9;i++)
			dp[1][i] = 1;
		
		
		//dp
		for(int i=2;i<=10;i++) {
			for(int j=0;j<=9;j++) {
				if(j==4) continue;
				for(int k=0;k<=9;k++) {
					if(k==4 || (j==6 && k==2)) continue;
					dp[i][j] += dp[i-1][k];
				}
			}
		}
	}
	static int count(int n) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while(n>0) {
			nums.add(n%10);
			n/=10;
		}
		n = nums.size();
		int sum = 0,last = -1;
		for(int i=n-1;i>=0;i--) {
			int x = nums.get(i);
			for(int j=0;j<x;j++) {
				if(j==4) continue;
				if(last==6 && j==2) continue;
				sum += dp[i+1][j];
			}
			last = x;
		}
		return sum;
	}
	static int gcd(int a,int b) {
		return b==0?a:gcd(b,a%b);
	}
	static int[][] group = new int[120][120];
	static int[] cnt = new int[120];
	static void dfs(int i,int zuCnt) {
		if(i==n+1) {
			ans = Math.min(ans,zuCnt);
			return;
		}
		int ok = 1;
		for(int j=1;j<=zuCnt;j++) {
			int flag = 1;
			for(int k=0;k<cnt[j];k++) {
				if(gcd(arr[i],group[j][k])!=1) {
					flag = 0;
					break;
				}
			}
			if(flag == 1) {
				ok = 0;
				group[j][cnt[j]] = arr[i]; 
				cnt[j]++;
				dfs(i+1,zuCnt);
				cnt[j]--;
			}
		}
		if(ok==1) {
			zuCnt++;
			group[zuCnt][0] = arr[i];
			cnt[zuCnt]++;
			dfs(i+1,zuCnt);
			cnt[zuCnt]--;
			zuCnt--;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		dfs(1,0);
		System.out.println(ans);
	}
}
class Read{
	StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//	PrintWriter out = new PrintWriter(System.out);
//	out.flush();
	int nextInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	String getLine() throws IOException {
		return r.readLine();
	}
}
