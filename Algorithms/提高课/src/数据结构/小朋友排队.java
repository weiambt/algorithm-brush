package 数据结构;
import java.util.*;
import java.math.*;
import java.io.*;

public class 小朋友排队 {
		static int INF = 0x3f3f3f3f;
		static int N = 1010000 , M = 2*N;
		static int[] arr = new int[N],tree = new int[N],sum = new int[N];
		static int n,m;
		static long ans;
		static int lowbit(int x) {
			return x&-x;
		}
		static void add(int idx,int val) {
			for(int i=idx;i<N;i+=lowbit(i))
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
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=1;i<=n;i++) {
				sum[i] = (int) (sum(N-1) - sum(arr[i]));
				add(arr[i], 1);
//				System.out.println(sum[i]);
			}
			Arrays.fill(tree,0);
			for(int i=n;i>=1;i--) {
				sum[i] += (int)sum(arr[i]-1);
				add(arr[i], 1);
				ans += (long)sum[i]*(sum[i]+1)/2;
//				System.out.println(sum[i]);
			}
			System.out.println(ans);

		}
}
