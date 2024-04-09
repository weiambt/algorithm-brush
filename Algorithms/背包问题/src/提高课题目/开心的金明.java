package 提高课题目;
import java.util.*;
/**
 * 代价函数：v[i]
 * 价值函数：w[i]*v[i]
 **/
public class 开心的金明 {
	static int N = 30010;
	static int[] dp = new int[N];
	static int m,n;
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		int a,b;
		for(int i=1;i<=n;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			for(int j=m;j>=a;j--)
				dp[j]=Math.max(dp[j],dp[j-a]+b*a);
		}
		System.out.println(dp[m]);
	}
}
