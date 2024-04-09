package _05讲_树状数组线段树;

import java.util.*;
import java.math.*;

public class _01动态求连续区间和_树状数组 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] arr = new int[N];
	static int[] tree = new int[N];
	static int n,m;
	static int lowbit(int x) {
		return x&-x;
	}
	//在arr[x]的值添加v
	static void add(int x,int v) {
		for(int i=x;i<=n;i+=lowbit(i)) {
			tree[i]+=v;
		}
	}
	//计算arr[1~x]的和
	static int query(int x) {
		int res = 0;
		for(int i=x;i>0;i-=lowbit(i)) {
			res += tree[i];
		}
		return res;
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) 
			arr[i] = sc.nextInt();
		//构建树状数组
		for(int i=1;i<=n;i++)
			add(i,arr[i]);
		int op,x,y;
		while(m-->0) {
			op = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			if(op==0) 
				System.out.println(query(y) - query(x-1));
			else
				add(x,y);
		}
		
	}

}
