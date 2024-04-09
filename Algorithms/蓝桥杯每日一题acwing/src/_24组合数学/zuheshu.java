package _24组合数学;

import java.util.Scanner;

public class zuheshu {
	static int N = 101000;
	static int Mod = (int) (1e9+7);
	static long[] jiechen = new long[N],jiechenniyuan = new long[N]; 
	static long qpow(long a,long b) {
		long res = 1;
		while(b>0) {
			if((b&1)==1) res = res * a%Mod;
			a = a*a%Mod;
			b >>= 1;
		}
		return res;
	}
	static void init() {
		
		jiechen[0] = 1;
		jiechenniyuan[0] = 1;
		for(int i=1;i<N;i++) {
			jiechen[i] = jiechen[i-1]*i%Mod;
			jiechenniyuan[i] = jiechenniyuan[i-1]*qpow(i, Mod-2)%Mod;
		}
			
	}
	public static void main(String[] args) {
		init();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long res = jiechen[a] * jiechenniyuan[b] % Mod * jiechenniyuan[a-b]%Mod;
			System.out.println(res);

		}
	}
	
	
}
