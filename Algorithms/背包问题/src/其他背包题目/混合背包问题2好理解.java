package ����������Ŀ;
import java.util.*;
/**
 *  ˼·2�������ر�������ȫ��������������m/v[i]����
 * @author ZW
 *
 */
public class ��ϱ�������2����� {
	static int N = 100100;
	static int[] v =new int[N];
	static int[] w =new int[N];
	static int[] dp =new int[N];
	static int idx=1;
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int vv,ww,s;
		for(int i=1;i<=n;i++) {
			vv = sc.nextInt();
			ww = sc.nextInt();
			s = sc.nextInt();
			if(s==0) {//��ȫ����
				s = m/vv;
			}
			else if(s==-1) {//01����
				s = 1;
			}
			for(int k=1;s-k>0;k*=2) {
				v[idx] = vv*k;
				w[idx] = ww*k;
				idx++;
				s -= k;
			}
			if(s>0) {
				v[idx] = vv*s;
				w[idx] = ww*s;
				idx++;
			}
		}
		
		for(int i=1;i<=idx;i++)
			for(int j=m;j>=v[i];j--)
				dp[j]=Math.max(dp[j], dp[j-v[i]]+w[i]);
		System.out.println(dp[m]);
	}
}

