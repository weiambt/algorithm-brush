package ��߿���Ŀ;
import java.util.*;

/**
 * С��������nԪǮȫ���������飬��ļ۸�Ϊ10Ԫ��20Ԫ��50Ԫ��100Ԫ��
 * ��С���ж��������鷽������ÿ����ɹ���౾��
 * 
 * ��ȫ�����ı����ⷨ
 * dp[i][j]��ʾǡ���ܹ���jԪǮ�ķ�����
 * dp[i][j] = dp[i-1][j] + dp[i-1][j-k*arr[i]]
 * @author ZW
 *
 */
public class _05���� {
	static int N =1010;
	static int[] arr = {0,10,20,50,100};
	static int[][] dp = new int[5][N];
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		int m;
		m = sc.nextInt();
		for(int i=0;i<=4;i++) dp[i][0]=1;
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=m;j++) {
				for(int k=0;k*arr[i]<=j;k++) {
					dp[i][j]+=dp[i-1][j-k*arr[i]];
				}
			}
		}
		System.out.println(dp[4][m]);
	}
}
