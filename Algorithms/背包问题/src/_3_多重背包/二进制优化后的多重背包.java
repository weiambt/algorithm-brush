package _3_多重背包;
import java.util.*;
/*
 * 二进制优化
 */

public class 二进制优化后的多重背包 {
	static int N = 13000;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] dp = new int[N];
	static int n,m;
	static int cnt;
	public static void main(String[] str) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int a,b,c;
		for(int i=1;i<=n;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			for(int j=1;j<=c;j*=2) {
				c-=j;
				cnt++;
				v[cnt]=j*a;
				w[cnt]=j*b;
			}
			if(c>0) {
				cnt++;
				v[cnt]=c*a;
				w[cnt]=c*b;
			}
		}
		n = cnt;
		for(int i=1;i<=n;i++)
			for(int j=m;j>=v[i];j--)
				dp[j]=Math.max(dp[j], dp[j-v[i]]+w[i]);
		System.out.println(dp[m]);
	}
}
