package ��߿���Ŀ;

import java.util.*;
/**
 * �����еĵ� i �����ֱ�ʾһ��������Ʊ�ڵ� i ��ļ۸����һ���㷨������������
 * 	�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
	������Ʊ�����޷��ڵڶ��������Ʊ (���䶳��Ϊ 1 ��)��
 * @author ZW
 *
 */

public class ��Ʊ����V {
	static int N = 101000;
	static int INF = 0x3f3f3f3f;
	static int w[] = new int[N];
	static int dp[][] = new int[N][3];
	//�������һ��Ŀղ�״̬�ٷֳ���������״̬
	//dp[i][j]��ʾǰi������i����״̬��j�����ֵ
	//0:�л�������ֲ�
	//1:�ղֵ�һ�죬�����䶳��
	//2:�ղֵڶ��죬�������
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			w[i] = sc.nextInt();
		}
		
//      �ղֵڶ����״̬����㣬ʣ������״̬�ǷǷ�״̬
//		for(int i=0;i<=n;i++) {
//			Arrays.fill(dp[i],-INF);
//		}
		dp[0][0]=-INF;
 		dp[0][1]=-INF; 
        dp[0][2]=0;

		for(int i=1;i<=n;i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-w[i]);
			dp[i][1] = dp[i-1][0]+w[i];
			dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
		}
		
		System.out.println(Math.max(dp[n][1], dp[n][2]));
	}
}
