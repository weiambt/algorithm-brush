package 提高课题目;
import java.util.*;
/**
 * 二维写法 能AC
 * @author ZW
 *
 */
public class 股票买卖IV2 {
	static int N = 101000;
	static int INF = 0x3f3f3f3f;
	static int w[] = new int[N];
	static int dp[][] = new int[110][2];
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			w[i] = sc.nextInt();
		}
		//二维数组赋值
		for(int i=0;i<110;i++) {
			Arrays.fill(dp[i],-INF);
		}
		
		//起点：将所有从前i天中，一次也不交易，手中无货的情况初始化成0，因为这种状态，肯定是一点收益没有
		dp[0][0]=0;

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				dp[j][0]= Math.max(dp[j][0], dp[j][1]+w[i]);
				dp[j][1]= Math.max(dp[j][1], dp[j-1][0]-w[i]);
			}
		}
		int ans=0;
		for(int j=1;j<=k;j++) {
			ans = Math.max(ans, dp[j][0]);
		}
		System.out.println(ans);
	}
}
