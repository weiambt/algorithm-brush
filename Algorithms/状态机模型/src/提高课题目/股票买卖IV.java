package ��߿���Ŀ;
import java.util.*;
/**
 *  * ��άд����TLE
 * ����һ������Ϊ N �����飬�����еĵ� i �����ֱ�ʾһ��������Ʊ�ڵ� i ��ļ۸�
	���һ���㷨�����������ܻ�ȡ�������������������� k �ʽ��ס�
		ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����һ������������Ϊһ�ʽ��ס�
 * @author ZW
 *
 */
public class ��Ʊ����IV {
	static int N = 101000;
	static int INF = 0x3f3f3f3f;
	static int w[] = new int[N];
	static int dp[][][] = new int[N][110][2];
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			w[i] = sc.nextInt();
		}
		
		//��ά�����ʼ��
		for(int i=1;i<=n;i++) {
			for(int j=0;j<110;j++) {
				Arrays.fill(dp[i][j],-INF);
			}
		}
		
		//�����д�ǰi���У�һ��Ҳ�����ף������޻��������ʼ����0����Ϊ����״̬���϶���һ������û��
        for(int i = 0 ; i <= n ; i ++ ) 
            dp[i][0][0] = 0;

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				dp[i][j][0]= Math.max(dp[i-1][j][0], dp[i-1][j][1]+w[i]);
				dp[i][j][1]= Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-w[i]);
			}
		}
		int ans=0;
		for(int j=1;j<=k;j++) {
			ans = Math.max(ans, dp[n][j][0]);
		}
		System.out.println(ans);
	}
}
