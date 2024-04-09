package 搜索;

import java.util.*;
import java.math.*;
import java.io.*;

public class _tt {
	static int INF = 0x3f3f3f3f;
	static int N = 109000 , M = 2*N;
	static int n,m;
	static TreeMap<Integer,Integer> mp = new TreeMap<Integer, Integer>();
	static int[][] q = new int[3*N][3];
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			int idx = sc.nextInt();
			int val = sc.nextInt();
			mp.put(idx,mp.getOrDefault(idx, 0)+val);
		}
		
		for(int i=0;i<m;i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			q[i][0] = l;q[i][1] = r;
			mp.put(l, mp.getOrDefault(l, 0));
			mp.put(r, mp.getOrDefault(r, 0));
		}
		Integer[] keys =  mp.keySet().toArray(new Integer[1]);
		for(int i=1;i<keys.length;i++) {
			mp.put(keys[i],mp.get(keys[i])+mp.get(keys[i-1]));
		}
		
		for(int i=0;i<m;i++) {
			int l = q[i][0];
			int r = q[i][1];
			if(l==keys[0])
//				System.out.println(mp.ceilingEntry(r).getValue());//可以这么写
				System.out.println(mp.get(r));
			else
//				System.out.println(mp.get(r)-mp.get(l-1));//不能这么写！！！
				System.out.println(mp.get(r)-mp.lowerEntry(l).getValue());
				
		}
	}
}
