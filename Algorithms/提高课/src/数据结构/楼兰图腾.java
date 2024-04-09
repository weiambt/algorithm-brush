package 数据结构;
import java.util.*;
import java.math.*;
import java.io.*;

public class 楼兰图腾 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int[] arr = new int[N],qian = new int[N],hou = new int[N];
		static int[] houLess = new int[N],houMore = new int[N];
		static int n,m,ans1,ans2;
		static int lowbit(int x) {
			return x&-x;
		}
		static void add(int[] tree,int idx,int val) {
			for(int i=idx;i<=n;i+=lowbit(i))
				tree[i]+=val;
		}
		static int sum(int[] tree,int idx) {
			int res = 0;
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
			add(hou,arr[n],1);
			for(int i=n-1;i>1;i--) {
				houLess[i] = sum(hou,arr[i]);
				houMore[i] = n-i-houLess[i];
				add(hou,arr[i],1);
//				System.out.println(houLess[i]+" "+houMore[i]);
			}
			add(qian,arr[1],1);
			for(int i=2;i<n;i++) {
				int qianLess = sum(qian,arr[i]);
				int qianMore = i-1-qianLess;
				ans1 += qianMore*houMore[i];
				ans2 += qianLess*houLess[i];
				add(qian,arr[i],1);
			}
			System.out.println(ans1+" "+ans2);
		}
}
