package ��߿���Ŀ;
import java.util.*;

public class _03����С����֮�շ� {
	static int N = 1010;
	static int[] a = new int[N];//��������
	static int[] b = new int[N];//��������
	static int n,m,k;
	static int[][] dp = new int[N][N];
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();//��ʼ����������
		m = sc.nextInt();//��ʼ����
		n = sc.nextInt();//��������
		
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=k;j>=0;j--) {
				for(int t=m;t>=0;t--) {
					if(j>=a[i] && t >= b[i])
						dp[j][t] = Math.max(dp[j][t],dp[j-a[i]][t-b[i]]+1);
				}
			}
		}
		System.out.print(dp[k][m-1]);//������Ϊ0ʱ��Ƥ����ͼ��ˣ���ֹͣ�����ˣ������������m-1������
		if(dp[k][m-1]==0) System.out.printf(" %d",m);
		else
			for(int i=1;i<=m-1;i++) {
				if(dp[k][i]==dp[k][m-1]) {//��С����ö��������ҵ���һ��ץ���ĸ������ڴ𰸵��Ǹ����
					System.out.printf(" %d",m-i);
					break;
				}
			}
	}
}
