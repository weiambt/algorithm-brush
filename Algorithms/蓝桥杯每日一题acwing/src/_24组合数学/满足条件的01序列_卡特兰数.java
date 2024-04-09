package _24组合数学;

import java.util.*;

public class 满足条件的01序列_卡特兰数 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int Mod = 1000000007;
	static int n,a,b;
	static long[] jiechen = new long[N];
	static long[] jiechenniyuan = new long[N];
	static void init() {
		jiechen[0] = 1;
		jiechenniyuan[0] = 1;
		for(int i=1;i<N;i++) {
			jiechen[i] = jiechen[i-1] * i%Mod;
			jiechenniyuan[i] = jiechenniyuan[i-1] * qpow(i, Mod-2)%Mod;
		}
	}
	static long C(int a,int b) {
		long res = 1;
		res = res * jiechen[a]%Mod;
		res = res * jiechenniyuan[b]%Mod;
		res = res * jiechenniyuan[a-b]%Mod;
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		init();
		System.out.println(C(2*n,n)%Mod-C(2*n,n-1)%Mod);
	}
	static long qpow(long a,long b) {
		long res = 1;
		while(b>0) {
			if((b&1)==1) res = res * a%Mod;
			a = a*a%Mod;
			b>>=1;
		}
		return res;
	}

	
}

