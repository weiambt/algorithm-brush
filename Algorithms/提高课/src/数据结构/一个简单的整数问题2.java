package 数据结构;
import java.util.*;
import java.math.*;
import java.io.*;

public class 一个简单的整数问题2 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static long[] arr = new long[N],tree = new long[N],tree2 = new long[N];
		static int n,m;
		static int lowbit(int x) {
			return x&-x;
		}
		static void add(long[] tree,int idx,long val) {
			for(int i=idx;i<=n;i+=lowbit(i))
				tree[i]+=val;
		}
		static long sum(long[] tree,int idx) {
			long res = 0;
			for(int i=idx;i>0;i-=lowbit(i))
				res += tree[i];
			return res;
		}
		static long getSum(int idx) {
			return (idx+1)*sum(tree,idx)-sum(tree2,idx);
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
				add(tree,i,(long)(arr[i]-arr[i-1]));
				add(tree2,i,(long)(arr[i]-arr[i-1])*i);
			}
			while(m-->0) {
				String op = sc.next();
				if(op.equals("Q")) {
					int l = sc.nextInt();
					int r = sc.nextInt();
					System.out.println(getSum(r)-getSum(l-1));
				}else {
					int l = sc.nextInt();
					int r = sc.nextInt();
					int d = sc.nextInt();
					add(tree,l,d);
					add(tree2,l,l*d);
					add(tree,r+1,-d);
					add(tree,r+1,-(r+1)*d);
				}
			}
			

		}
}
