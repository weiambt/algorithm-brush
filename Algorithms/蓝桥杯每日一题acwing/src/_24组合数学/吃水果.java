package _24组合数学;

import java.util.*;

public class 吃水果 {
	static int INF = 0x3f3f3f3f;
	static int Mod = 998244353;
	static int N = 3010 , M = 2*N;
	static int n,m,k;
	static long[][] C = new long[N][N];
	static void init() {
		for(int i=0;i<N;i++)
			for(int j=0;j<=i;j++)
				if(j>0) C[i][j] = (C[i-1][j] + C[i-1][j-1])%Mod;
				else C[i][j] = 1;
	}
	static long qpow(long a,long b) {
		long res = 1;
		while(b>0) {
			if((b&1)==1) res = res * a %Mod;
			a = a*a%Mod;
			b >>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		init();
		System.out.println(C[n-1][k]*m%Mod*qpow(m-1,k)%Mod);
	}
	
}

