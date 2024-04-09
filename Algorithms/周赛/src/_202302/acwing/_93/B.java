package _202302.acwing._93;

import java.util.*;
import java.io.*;
import java.math.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static int[] arr = new int[N];
	static int n,m,cnt,ans;
	static long x;
	static int find(long x) {
		int res = -1;
		while(x>0) {
			res = Math.max(res, (int)x%10);
			x/=10;
			cnt++;
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		n = sc.nextInt();
		x = sc.nextLong();
		long res = x;
//		System.out.println(res);
		if(x==1) {
			System.out.println(-1);
			return;
		}
//		System.out.println(res);
		while(true) {
			cnt = 0;
			int u = find(res);
			System.out.println(u+" "+cnt);
			if(cnt==n) {
				break;
			}
			ans++;
			res *= u; 
		}
		System.out.println(ans);
	}
}
