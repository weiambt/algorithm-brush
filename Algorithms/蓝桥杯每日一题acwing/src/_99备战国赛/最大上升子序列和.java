package _99备战国赛;

import java.util.*;
import java.math.*;
import java.io.*;

public class 最大上升子序列和 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static long[] arr = new long[N],tree = new long[N];
	static int n;
	
	static int lowbit(int x) {
		return x&-x;
	}
	static void solveMax(int idx,long val) {
		for(int i=idx;i<N;i+=lowbit(i))
			tree[i]= Math.max(tree[i],val);
	}
	
	static long sum(int idx) {
		long res = 0;
		for(int i=idx;i>0;i-=lowbit(i))
			res = Math.max(res, tree[i]);
		return res;
	}
	static int find(Integer[] q,int l,int r,int x) {
		while(l<r){
			int mid = l+r>>1;
			if(q[mid]>=x) r= mid;
			else l = mid+1;
		}
		return l;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> se = new TreeSet<Integer>();
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
			se.add((int)arr[i]);
		}
		Integer[] q = se.toArray(new Integer[0]);
		int sz = q.length;
		long ans = 0;
		for(int i=1;i<=n;i++) {
			int idx = find(q,0,sz-1,(int)arr[i])+1;
			long val = sum(idx-1)+arr[i];
			solveMax(idx,val);
			ans = Math.max(ans,val);
		}
		System.out.println(ans);
	}
	
}

