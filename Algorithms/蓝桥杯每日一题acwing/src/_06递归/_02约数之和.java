package _06递归;

import java.util.*;
import java.math.*;
import java.io.*;

public class _02约数之和 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , mod = 9901;
	static int a,b;
	static int qpow(int a,int b) {
		int res = 1;
		while(a>0) {
			if((b&1)>0) res = res*a%mod;
			b>>=1;
			a*=a;
		}
		return res;
	}
	static int sum(int p,int k) {
		if(k==1) return p+1;
		if(k%2==1) {
			int x1 =sum(p, k/2);
//			System.out.println(x1+" "+x2);
			return sum(p, k/2)*(qpow(p,k/2+1)+1)%mod;
		}
		return (sum(p, k-1)+qpow(p,k))%mod;
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		int res = 1;
		for(int i=2;i<=a/i;i++) {
			if(a%i==0) {
				int s=0;
				while(a%i==0) {
					s++;
					a/=i;
				}
				System.out.println(i+" "+s);
				res = res * sum(i,s*b)%mod;
			}
		}
//		System.out.println(a+" "+b);
		if(a>1) res = res * sum(a, b) %mod;
		System.out.println(res);
	}
	
}
