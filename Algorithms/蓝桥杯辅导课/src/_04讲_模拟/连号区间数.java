package _04��_ģ��;

import java.util.*;

public class ���������� {
	static int INF = 0x3f3f3f3f;
	static int N = 1001000,M = 2*N;
	static int n;
	static int[] arr = new int[N];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++)
			arr[i] = sc.nextInt();
		int ans = 0;
		for(int i=1;i<=n;i++) {
			int mi=arr[i],ma=arr[i];
			ans++;
			for(int j=i+1;j<=n;j++) {
				mi = Math.min(mi, arr[j]);
				ma = Math.max(ma, arr[j]);
				if(ma-mi == j-i)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
