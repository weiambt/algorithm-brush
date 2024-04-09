package _06讲_双指针BFS与图论;

import java.util.*;
import java.math.*;
import java.io.*;

public class _05完全二叉树的权值 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static long[] s = new long[N];
	static int n,m;
	static long mx,idx;
	static int pow(int a,int b) {
		int res = 1;
		while(b>0) {
			if((b&1)>0) res *= a;
			a *= a;
			b >>= 1;
		}
		return res;
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			s[i] = s[i-1] +sc.nextInt();
		}
		for(int i=1;pow(2,i)-1<=n;i++) {
			int a = pow(2,i)-1;
			int b = pow(2,i-1)-1;
			if(s[a]-s[b]>mx) {
				mx = s[a]-s[b];
				idx = i;
			}
		}
		System.out.println(idx);
	}
}
