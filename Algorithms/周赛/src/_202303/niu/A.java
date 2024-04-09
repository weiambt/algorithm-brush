package _202303.niu;
import java.util.*;
import java.math.*;
import java.io.*;

public class A {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static long n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
			PrintWriter out = new PrintWriter(System.out);
			m = sc.nextInt();
			while(m-->0) {
				n = sc.nextLong();
				if(n%2==0)out.println(n==0?"0":"2");
				else out.println(n==1?"1":"3");
			}
			
			out.flush();
		}
}
