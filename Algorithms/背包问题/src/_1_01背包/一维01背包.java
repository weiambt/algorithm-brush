package _1_01±³°ü;
import java.util.*;

public class Ò»Î¬01±³°ü {
	static int N = 10100;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] dp = new int[N];
	static int n,m;
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++)
			for(int j=m;j>=v[i];j--)
				dp[j]=Math.max(dp[j],dp[j-v[i]]+w[i]);
		
		System.out.println(dp[m]);
	}
}
