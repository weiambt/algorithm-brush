package ��߿���Ŀ;
import java.util.*;
/**
 * ���ۺ�����v[i]
 * ��ֵ������w[i]*v[i]
 **/
public class ���ĵĽ��� {
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
