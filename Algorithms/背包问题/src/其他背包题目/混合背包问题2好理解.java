package 其他背包题目;
import java.util.*;
/**
 *  思路2：纯多重背包（完全背包的最大个数是m/v[i]个）
 * @author ZW
 *
 */
public class 混合背包问题2好理解 {
	static int N = 100100;
	static int[] v =new int[N];
	static int[] w =new int[N];
	static int[] dp =new int[N];
	static int idx=1;
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int vv,ww,s;
		for(int i=1;i<=n;i++) {
			vv = sc.nextInt();
			ww = sc.nextInt();
			s = sc.nextInt();
			if(s==0) {//完全背包
				s = m/vv;
			}
			else if(s==-1) {//01背包
				s = 1;
			}
			for(int k=1;s-k>0;k*=2) {
				v[idx] = vv*k;
				w[idx] = ww*k;
				idx++;
				s -= k;
			}
			if(s>0) {
				v[idx] = vv*s;
				w[idx] = ww*s;
				idx++;
			}
		}
		
		for(int i=1;i<=idx;i++)
			for(int j=m;j>=v[i];j--)
				dp[j]=Math.max(dp[j], dp[j-v[i]]+w[i]);
		System.out.println(dp[m]);
	}
}

