package 例题;

import java.util.*;
import java.math.*;
import java.awt.Color;
import java.io.*;

public class sort2 {
		static int INF = 1000000007;
		static int N = 101000 , M = 2*N;
		static int n1,n2,m,idx;
		static long ans;
		//match[i]=j表示右半边节点i当前匹配的是左半边的节点j
		//st[i]表示当前轮次的右半边节点i是否被标记过
		static int[] match = new int[N],st = new int[N];
		static int[] h = new int[N],e = new int[M],ne = new int[M];
		static void add(int a,int b) {
			e[idx] = b;
			ne[idx] = h[a];
			h[a] = idx++;
		}
		
		//左边节点u向右边匹配，返回值为是否能够匹配成功
		static boolean find(int u) {
			for(int i=h[u];i!=-1;i=ne[i]) {
				int j = e[i];
				if(st[j]==0) {
					st[j] = 1;
					if(match[j]==0 || find(match[j])) {
						match[j] = u;
						return true;
					}
				}
			}
			return false;
		}
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			m = sc.nextInt();
			Arrays.fill(h,-1);
			for(int i=1;i<=m;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				add(a,b);
			}
			
			for(int i=1;i<=n1;i++) {
				Arrays.fill(st,0);
				if(find(i)) ans++;

			}
			System.out.println(ans);
			
			
		}
		
}
