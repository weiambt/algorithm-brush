package ��߿���Ŀ;
import java.util.*;
/**
 * ��ֵ�����������01��������
 * @author ZW
 *
 */
public class _02װ������ {
	static int N = 50;
	static int M = 20200;
	static int[] v = new int[N];
	static int[] dp = new int[M];
	static int m,n;
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			v[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++)
			for(int j=m;j>=v[i];j--)
				dp[j]=Math.max(dp[j], dp[j-v[i]]+v[i]);
		//dp[m]��ʾ���Ϊm�ı������װ�µ���Ʒ�������
		//m-dp[m]�����������С�Ŀռ�
		System.out.println(m-dp[m]);
	}
}
