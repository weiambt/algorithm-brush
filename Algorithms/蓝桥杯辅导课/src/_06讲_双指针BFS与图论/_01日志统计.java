package _06讲_双指针BFS与图论;

import java.util.*;
import java.math.*;
import java.io.*;

public class _01日志统计 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static Integer[][] arr = new Integer[N][2];
	static HashMap<Integer,Integer> mp = new HashMap<>();
	static Set<Integer> ans = new TreeSet<Integer>();
	static int n,d,k;
	static int[] q = new int[N*8];
	static int hh=0,tt=-1;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = sc.nextInt();
		k = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		//先根据时间升序，再根据id升序
		Arrays.sort(arr,1,n+1,(a,b)->(
				a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]));
		
		for(int i=1;i<=n;i++) {
			int now = arr[i][0];
			//删除不在区间中的元素
			while(hh<=tt && arr[q[hh]][0] < now - d +1) {
//				mp[arr[q[hh]][1]] --;
				mp.put(arr[q[hh]][1],mp.get(arr[q[hh]][1])-1);
				hh++;
			}
			mp.put(arr[i][1],mp.getOrDefault(arr[i][1], 0)+1);
			
			if(mp.getOrDefault(arr[i][1], 0) >= k) 
				ans.add(arr[i][1]);

			q[++tt] = i;
		}
		for(Integer i:ans)System.out.println(i);
	}
}
