package _202302.acwing_acc2;


import java.util.*;
import java.io.*;
import java.math.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static int n,bx,m,by;

	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		n = sc.nextInt();
		bx = sc.nextInt();
		long x = 0;
		for(int i=1;i<=n;i++) {
			int ii = sc.nextInt();
			x = x*bx + ii;
		}
		
		m = sc.nextInt();
		by = sc.nextInt();
		long y = 0;
		for(int i=1;i<=m;i++) {
			int ii = sc.nextInt();
			y = y*by + ii;
		}

		if(x==y) System.out.println("=");
		else if(x<y) System.out.println("<");
		else System.out.println(">");
	}
}
