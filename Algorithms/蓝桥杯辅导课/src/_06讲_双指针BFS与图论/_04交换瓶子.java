package _06讲_双指针BFS与图论;

import java.util.*;
import java.math.*;
import java.io.*;

public class _04交换瓶子 {
	static int INF = 0x3f3f3f3f;
	static int N = 10010 , M = 2*N;
	static int[] arr = new int[N];
	static int[] mp = new int[N];
	static int n,m;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
			mp[arr[i]]=i;
		}
		int ans=0;
		for(int i=1;i<n;i++) {
			int idx = mp[i];
			if(idx!=i) {
				int t = arr[i];
				arr[i] = i;
				arr[idx] = t;
				mp[i]=i;
				mp[arr[idx]]=idx;
				ans++;
			}
		}
		System.out.println(ans);
		
	}
}
