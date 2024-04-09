package _202302.acwing._91;
import java.util.*;
import java.math.*;
import java.io.*;

public class A {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int[] ans = new int[N];
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			m = sc.nextInt();
			while(m-->0) {
				n = sc.nextInt();
				int cnt = 0,t = 1;
				while(n>0) {
					if(n%10==0) {
						t*=10;
						n/=10;
						continue;
					}
					ans[cnt++] = (n%10)*t;
					t *= 10;
					n/=10;
				}
				System.out.println(cnt);
				for(int i=0;i<cnt;i++)
					System.out.print(ans[i]+" ");
				if(cnt>0)
					System.out.println();
			}
		}
}
