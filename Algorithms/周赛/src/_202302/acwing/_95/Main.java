package _202302.acwing._95;


import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
	static int INF = 0x3f3f3f3f;
	static int N = 1001000,M = 2*N;
	static int n;
	static int[] st = new int[N];
	static void getPrimes(int n) {
		for(int i=2;i<=n;i++) {
			if(st[i]==0) {
				for(int j=i+i;j<=n;j+=i)
					st[j] = 1;
			}
		}
	}
	static long solve(long x) {
		long l = 1,r = x;
//		BigInteger bigInteger = new BigInteger(val);
		while(l<r) {
			long mid = (l + r +1)/2;

			if(mid  <= x/mid) l = mid;
			else r = mid - 1;
		}
		return l;
	}
// 1
// 999966000289
	public static void main(String[] args) {
		Scanner sc =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		n = sc.nextInt();
		getPrimes(N-1);
		while(n-->0) {
			long x = sc.nextLong();
			if(x==1){
			    System.out.println("NO");
			    continue;
			}
			long t = solve(x);
			System.out.println(t);
            // if(t>N) System.out.println("NO");
			if(st[(int)t]==0 && t*t==x) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
