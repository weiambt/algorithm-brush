package ��߿���Ŀ;
import java.util.*;
/**
 * ��01����
 * @author ZW
 *
 */
public class _01��ҩ {
	static int N =1010;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] dp =  new int[N];
	static int t,m;
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();//ʱ��
		m = sc.nextInt();//����
		
		for(int i=1;i<=m;i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		
		for(int i=1;i<=m;i++)
			for(int j=t;j>=v[i];j--)
				dp[j]=Math.max(dp[j],dp[j-v[i]]+w[i]);
		
		System.out.println(dp[t]);
	}
}
