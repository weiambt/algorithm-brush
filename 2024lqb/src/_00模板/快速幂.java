package _00Ä£°å;

public class ¿ìËÙÃÝ {
	static long qpow(long a,long b,int mod) {
		long res = 1;
		while(b>0) {
			if((b&1)==1) res = res * a % mod;
			b>>=1;
			a *= a;
			a %= mod;
		}
		return res%mod;
	}
	public static void main(String[] args) {
		System.out.println(qpow(10,10,10000));
	}
}
