package _202303.luogu;
import java.util.*;
import java.math.*;
import java.io.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 1001000 , M = 2*N;

	static int n,x;
	static int qpow(int a,int b) {
		int res = 1;
		while(b>0) {
			if((b&1)>0) res *= a;
			a*=a;
			b>>=1;
		}
		return res;
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		n = sc.nextInt();
		if(x==n) System.out.println(0);
		else if(x>n) {
			System.out.println(n+1);
		}else {
			double k = Math.log(n)/Math.log(x);
			if(n%x==0 && Math.pow(x, k)==n) {
				System.out.println((int)k);
			}else {
				System.out.println(n/x);
			}
		}
	}


	
}



