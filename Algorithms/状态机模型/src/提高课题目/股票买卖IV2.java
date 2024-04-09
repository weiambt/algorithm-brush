package ��߿���Ŀ;
import java.util.*;
/**
 * ��άд�� ��AC
 * @author ZW
 *
 */
public class ��Ʊ����IV2 {
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
		//��ά���鸳ֵ
		for(int i=0;i<110;i++) {
			Arrays.fill(dp[i],-INF);
		}
		
		//��㣺�����д�ǰi���У�һ��Ҳ�����ף������޻��������ʼ����0����Ϊ����״̬���϶���һ������û��
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
