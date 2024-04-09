package 数据结构;
import java.util.*;
import java.math.*;
import java.io.*;

public class 一个简单的整数问题 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static long[] arr = new long[N],tree = new long[N];
		static int n,m;
		static int lowbit(int x) {
			return x&-x;
		}
		static void add(int idx,int val) {
			for(int i=idx;i<=n;i+=lowbit(i))
				tree[i]+=val;
		}
		static long sum(int idx) {
			long res = 0;
			for(int i=idx;i>0;i-=lowbit(i))
				res += tree[i];
			return res;
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
//				add(i,(int)arr[i]);
			}
			while(m-->0) {
				String op = sc.next();
				if(op.equals("Q")) {
					int x = sc.nextInt();
					System.out.println(arr[x]+sum(x));
				}else {
					int l = sc.nextInt();
					int r = sc.nextInt();
					int d = sc.nextInt();
					add(l,d);
					add(r+1,-d);
				}
			}
			

		}
}
