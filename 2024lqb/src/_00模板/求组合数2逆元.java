package _00模板;
import java.util.*;

public class 求组合数2逆元 {
	static int N = 10010000;
	static int Mod = 314324323;
	static long[] jiechen = new long[N];
	static long qpow(long a,long b) {
		long res = 1;
		while(b>0) {
			if((b&1)==1) res = res*a%Mod;
			b >>= 1;
			a = a*a%Mod;
		}
		return res;
	}
	static void init() {
		jiechen[0] = 1;
		for(int i=1;i<N;i++) {
			jiechen[i] = jiechen[i-1]*i%Mod;
			//其实阶乘逆元也是能递推的
			// niyuan(b!) = niyuan((b-1)! * b)
			// niyuan(b!) = niyuan((b-1)!) * niyuan(b)
		}
	}
	static long niyuan(long x) {
		return qpow(x,Mod-2);
	}
	// C(a,b) = a!/(b! * (a-b)!)
	// = a! * niyuan(b!) * niyuan((a-b)!)
	static long C(int a,int b) {
		long ans = jiechen[a];
		ans *= niyuan(jiechen[b]);
		ans %= Mod;
		ans *= niyuan(jiechen[a-b]);
		ans %= Mod;
		return ans;
	}
	
	public static void main(String[] args) {
		
	}
}
