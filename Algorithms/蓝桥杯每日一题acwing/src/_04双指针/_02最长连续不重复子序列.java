package _04双指针;

import java.util.*;
import java.math.*;
import java.io.*;

public class _02最长连续不重复子序列 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] arr = new int[N];
	static int n,m,ans = 0;
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for(int i=1,j=1;i<=n;i++) {
			while(mp.getOrDefault(arr[i],0)>0) {
				mp.put(arr[j],mp.get(arr[j])-1);
				j++;
			}
			mp.put(arr[i],1);
			ans = Math.max(ans, i-j+1);
		}
		System.out.println(ans);
	}
}
