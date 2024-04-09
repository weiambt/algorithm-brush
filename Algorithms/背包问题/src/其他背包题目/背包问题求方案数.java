package ����������Ŀ;
import java.util.*;
public class ���������󷽰��� {
	static int N = 1010;
	static int MOD = 1000000007;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] dp = new int[N];
	static long[] cnt = new long[N];
	//cnt[j]��ʾǰi����ѡ���������j������ֵ�ķ�����
	//1.���dp[i-1][j] > dp[i-1][j-v]+w ��ôcnt[i][j] = cnt[i-1][j];
	//2.���dp[i-1][j] < dp[i-1][j-v]+w ��ôcnt[i][j] = cnt[i-1][j-v];
	//3.���dp[i-1][j] == dp[i-1][j-v]+w ��ôcnt[i][j] = cnt[i-1][j] + cnt[i-1][j-v];
	
	//��ʼ����cnt[0~m] = 1;��ʾ��ǰ0����ѡ���Ϊ����ֵ�ķ�����Ϊ1
	
	//cnt[j]��ʼʱ����cnt[i-1][j]����ʾǰi-1�����������j�ķ�����
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int n,m;
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		
		//��ʼ��������ʾ��ǰ0����Ʒ��ѡ�����Ϊ����ֵ�ķ���������1
		for(int i=0;i<=m;i++) cnt[i]=1;
		
		for(int i=1;i<=n;i++) {
			for(int j=m;j>=v[i];j--) {
			    //ѡ��i��������ֵ
				int x = dp[j-v[i]]+w[i];
				//���ѡ���i��������ֵ�Ȳ�ѡʱ�Ĵ�
				if(dp[j] < x) {
					dp[j] = x;//��������ֵ
					cnt[j] = cnt[j-v[i]]%MOD;//���������ʹ�cnt[j-v[i]]�õ�
				}
				//�����ȣ���ôcnt�������Ҫ����������
				else if(dp[j]==x)
					cnt[j] = (cnt[j] + cnt[j-v[i]])%MOD;
				
			}
		}
// 		System.out.println(dp[m]);
		System.out.println(cnt[m]);
	}
}
