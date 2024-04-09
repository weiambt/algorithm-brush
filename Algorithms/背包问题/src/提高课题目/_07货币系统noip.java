package 提高课题目;
import java.util.*;
/**
 * 货币系统：有一个货币系统（a1,a2,...an），找到一个最小的m，使得另一组货币系统（b1,b2,...bm)与这组货币系统等价（可以相互线性表出）
 * 问题：求出(a1,a2,...an)的极大无关组的基的个数
 * 大前提：dp[i][j]表示从前i个中选，和为j的方案数
 * 方法：对a数组升序排序，判断dp[i-1][a[i]]是否等于0（dp[i-1][a[i]]表示从1~i-1中选择，能够表出a[i]的方案数，如果是0，那么就是无法表出，那么就是要保留的）
 * @author ZW
 *
 */
public class _07货币系统noip {
	static  int N = 202;
	static int[] dp = new int[30010];
	static int[] arr = new int[N];
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int ans=0;
			Arrays.fill(dp,0);//前一组的dp会干扰后面
			int n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr,1,n+1);
//			System.out.println(Arrays.toString(arr));
			int m = arr[n];
			dp[0]=1;
			for(int i=1;i<=n;i++) {
			    //如果dp[i-1][arr[i]]==0表示从前i-1个中选，和为arr[i]的方案数为0，那么就是无法表出的，那么就要保留
				if(dp[arr[i]]==0) ans++; 
				for(int j=arr[i];j<=m;j++) {
					dp[j] += dp[j-arr[i]];
				}
			}
			System.out.println(ans);
		}
	}
}
