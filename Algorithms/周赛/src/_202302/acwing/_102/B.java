package _202302.acwing._102;


import java.util.*;
import java.io.*;
import java.math.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static int[] arr = new int[N];
	static int n;
	static int gcd(int a,int b) {
		return b==0?a:gcd(b,a%b);
	}
	static int lcm(int a,int b) {
		return a*b/gcd(a,b);
	}
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		n = sc.nextInt();
		int lc = 1;
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
			lc = lcm(lc,arr[i]);
		}
		System.out.println(lc);
		for(int i=1;i<=n;i++) {
			int x = lc/arr[i];

			for(int j=2;j<=x/j;j++) {
				while(x%j==0) {
					if(j!=2 && j!=3) {
						System.out.println("No");
						return;
					}
					x/=j;
				}
			}
			if(x!=1 && x>0 && x!=2 && x!=3) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
		
	}
}

