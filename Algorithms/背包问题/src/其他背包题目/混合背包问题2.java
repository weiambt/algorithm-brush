package ����������Ŀ;
import java.util.*;
/**
 *  ˼·2�������ر�������ȫ��������������m/v[i]����
 * @author ZW
 *
 */
public class ��ϱ�������2 {
	static int N = 1010;
	static int[] dp =new int[N];
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v,w,s;
		for(int i=1;i<=n;i++) {
			v = sc.nextInt();
			w = sc.nextInt();
			s = sc.nextInt();
			if(s==0) {//��ȫ����
				s = m/v;
			}
			if(s==-1) {
				s = 1;//01����
			}
			
			for(int k=1;s-k>0;k*=2) {
				for(int j=m;j>=k*v;j--)
					dp[j]=Math.max(dp[j], dp[j-k*v]+k*w);
				s -= k;
			}
			if(s>0) {
				for(int j=m;j>=s*v;j--)
					dp[j]=Math.max(dp[j], dp[j-s*v]+s*w);
			}
		}
		System.out.println(dp[m]);
	}
}
