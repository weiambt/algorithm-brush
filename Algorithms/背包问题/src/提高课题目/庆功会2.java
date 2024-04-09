package 提高课题目;
import java.util.*;
//多重背包裸题
public class 庆功会2 {
	static int[] dp = new int[6060];
	static int[] v = new int[6060];
	static int[] w = new int[6060];
	static int idx;
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int vv,ww,s;
		for(int i=1;i<=n;i++) {
			vv = sc.nextInt();
			ww = sc.nextInt();
			s = sc.nextInt();
			for(int j=1;s-j>0;j*=2) {
				s -= j;
				v[idx] = j*vv;
				w[idx] = j*ww;
				idx++;
			}
			if(s>0) {
				v[idx] = s*vv;
				w[idx] = s*ww;
				idx++;
			}
		}
		
		for(int i=0;i<idx;i++)
			for(int j=m;j>=v[i];j--)
				dp[j]=Math.max(dp[j],dp[j-v[i]]+w[i]);
		System.out.println(dp[m]);
	}
}
