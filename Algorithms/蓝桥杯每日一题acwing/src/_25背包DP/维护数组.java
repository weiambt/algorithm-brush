package _25背包DP;
import java.util.*;
import java.math.*;
import java.io.*;

public class 维护数组 {
		static int INF = 0x3f3f3f3f;
		static int N = 1010 , M = 2*N;
		static int[] d = new int[N];
		static int[] tr1 = new int[N],tr2 = new int[N];
		static int n,k,a,b,q;

		
		static int lowbit(int x) {
			return x&-x;
		}
		static void add(int[] tr,int idx,int c) {
			for(int i=idx;i<=n;i+=lowbit(i)) 
				tr[i] += c;
		}
		
		static int query(int[] tr,int idx) {
			int res = 0;
			for(int i=idx;i>0;i-=lowbit(i))
				res += tr[i];
			return res;
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			k = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			q = sc.nextInt();
			
			while(q-->0) {
				int op = sc.nextInt();
				if(op==1) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					int cha = Math.min(d[x] + y, b) - Math.min(d[x], b);
					add(tr1, x, cha);
					int cha2 = Math.min(d[x] + y, a) - Math.min(d[x], a);
					add(tr2, x, cha2);
					d[x] += y;
				}else {
					int p = sc.nextInt();
					System.out.println(query(tr1, p-1) + query(tr2, n) - query(tr2, p+k-1));
				}
			}
		}
}
