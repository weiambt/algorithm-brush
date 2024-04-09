package _2023ецЬт;

import java.util.*;

public class E {
	static int Mod = 998244353 ;
	static long qpow(long a,long b) {
		a = a%Mod;
		long res = 1;
		while(b>0) {
			if((b&1)==1) res = res * a%Mod;
			a = a*a%Mod;
			b>>=1;
		}
		return res;
	}
	static HashSet<Integer> se = new HashSet<Integer>();
	static void divide(int n) {
		for(int i=2;i<=n/i;i++) {
			if(n%i==0) {
				se.add(i);
				while(n%i==0)
					n/=i;
			}
		}
		if(n>1) se.add(n);
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int a = sc.nextInt();
		long b = sc.nextLong();
		long res = qpow(a, b);

		divide((int)res);
		for(Integer i:se)
			res = res /i *(i-1)%Mod;
		System.out.println(res);
		
//		int nn = (int) res;
//		long ans = 0;
//		for(int i=1;i<=nn;i++) {
//			if(gcd(i,nn)==1)
//				ans = (ans +1)%Mod;
//		}
//		System.out.println(ans);
	}
	
	static int gcd(int a,int b) {
		return b==0?a:gcd(b,a%b);
	}
	
//	1000000000
//	1000000000000000000
//	461647536
}
