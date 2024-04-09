package 提高课题目;
import java.util.*;
/**
 * 裸01背包
 * @author ZW
 *
 */
public class _01采药 {
	static int N =1010;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] dp =  new int[N];
	static int t,m;
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();//时间
		m = sc.nextInt();//数量
		
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
