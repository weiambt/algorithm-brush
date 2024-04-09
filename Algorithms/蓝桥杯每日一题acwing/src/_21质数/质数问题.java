package _21质数;

import java.util.*;
import java.math.*;
import java.io.*;

public class 质数问题 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int n,k,m;
	static int[] primes = new int[N],st = new int[N];
	static int idx;
	static void getPrimes(int n) {
		for(int i=2;i<=n;i++) {
			if(st[i]==0) {
				primes[idx++] = i;
				for(int j=i+i;j<=n;j+=i)
					st[j] = 1;
			}
		}
	}
	static boolean check(int x) {
		for(int i=0;i<idx-1;i++) {
			int sum = primes[i] + primes[i+1] + 1;
			if(sum == x)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		while(m-->0) {
			idx = 0;
			Arrays.fill(st,0);
			n = sc.nextInt();
			k = sc.nextInt();
			getPrimes(n);
//			System.out.println(idx);
			int cnt = 0;
			for(int i=0;i<idx;i++) {
				if(check(primes[i])) cnt++;
			}
//			System.out.println(cnt);
			System.out.println(cnt>=k?"YES":"NO");

		}
	}
	
}
