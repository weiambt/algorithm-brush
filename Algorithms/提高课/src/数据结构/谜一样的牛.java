package 数据结构;
import java.util.*;
import java.math.*;
import java.io.*;

public class 谜一样的牛 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int[] arr = new int[N],tree = new int[N],ans = new int[N];
		static int n,m;
		static int lowbit(int x) {
			return x&-x;
		}
		static void add(int[] tree,int idx,int val) {
			for(int i=idx;i<=n;i+=lowbit(i))
				tree[i]+=val;
		}
		static long sum(int[] tree,int idx) {
			long res = 0;
			for(int i=idx;i>0;i-=lowbit(i))
				res += tree[i];
			return res;
		}
		static int find(int l,int r,int x) {
			while(l<r) {
				int mid = l+r>>1;
				if(sum(tree,mid)>=x) r = mid;
				else l = mid+1;
			}
			return l;
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=2;i<=n;i++) 
				arr[i] = sc.nextInt();
			
			for(int i=1;i<=n;i++) 
				add(tree,i,1);
			for(int i=n;i>=1;i--) {
				int idx = find(1,n,arr[i]+1);
				add(tree,idx,-1);
				ans[i] = idx;
			}
			for(int i=1;i<=n;i++)
				System.out.println(ans[i]);
			
			

		}
}
