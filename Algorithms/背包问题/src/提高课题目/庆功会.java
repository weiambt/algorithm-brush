package ��߿���Ŀ;
import java.util.*;
//���ر�������
public class �칦�� {
	static int[] dp = new int[6060];
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v,w,s;
		for(int i=1;i<=n;i++) {
			v = sc.nextInt();
			w = sc.nextInt();
			s = sc.nextInt();
			for(int j=m;j>0;j--) {
				for(int k=0;k<=s && k*v<=j;k++)
					dp[j] = Math.max(dp[j],dp[j-k*v]+k*w);
			}
		}
		System.out.println(dp[m]);
	}
}
