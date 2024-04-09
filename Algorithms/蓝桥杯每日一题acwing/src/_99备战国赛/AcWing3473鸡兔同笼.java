package _99备战国赛;
import java.util.*;
import java.math.*;
import java.io.*;

public class AcWing3473鸡兔同笼 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int[] dx = {1,0,-1,0};
		static int[] dy = {0,1,0,-1};
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			m = sc.nextInt();
			while(m-->0) {
				int ma=0,mi=INF;
				n = sc.nextInt();
				for(int i=0;i<=n/2;i++) {
					if((n-2*i)%4==0) {
						ma = Math.max(ma,i+(n-2*i)/4);
						mi = Math.min(mi,i+(n-2*i)/4);
					}
				}
				mi = mi!=INF?mi:0;
				System.out.println(mi+" "+ma);
			}
		}
}
