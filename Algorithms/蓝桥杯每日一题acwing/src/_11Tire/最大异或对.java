package _11Tire;
import java.util.*;
import java.math.*;
import java.io.*;

public class 最大异或对 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 31*N;
		static int[] arr = new int[N];
		static int[][] son = new int[M][2];
		static int n,m,idx,ans;
		//本题字典树中存放的是二进制数
		//字典树中插入一个数x
		static void insert(int x) {
			int p=0;
			for(int i=30;i>=0;i--) {//int是有符号整数，最多有31位数，0~30
				int u = x>>i&1;//这个数的第i位的数位值是u
				if(son[p][u]==0)//不存在就创建
					son[p][u] = ++idx;
				p = son[p][u];
			}
		}
		//查询x在已知的字典树能找到的异或的最大值
		static int query(int x) {
			int p=0,res = 0;
			for(int i=30;i>=0;i--) {
				int u = x>>i&1;//这一位是u，不是0就是1，
				//为了使得异或值最大，那么就要找一个和u不同的，这样才能保证这一位的异或值是1
				if(son[p][u==0?1:0]!=0) {//如果存在这个最佳情况
					res += 1<<i;//此时找到的这个数的这一位异或x的这一位一定是1，对于十进制答案的贡献就是2^i
					p = son[p][u==0?1:0];
				}else
					p = son[p][u];
			}
			return res;
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
				insert(arr[i]);
			}
			for(int i=1;i<=n;i++) {
				int mx = query(arr[i]);
				ans = Math.max(ans, mx);
			}
			System.out.println(ans);
		}
}
