package _06讲_双指针BFS与图论;

import java.util.*;
import java.math.*;
import java.io.*;

public class _04交换瓶子_置换环 {
	static int INF = 0x3f3f3f3f;
	static int N = 10010 , M = 2*N;
	static int[] arr = new int[N];
	static int[] vis = new int[N];
	static int n,m;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		int k=0;//记录初始共有多少新环
		for(int i=1;i<=n;i++) {
			if(vis[i]==0) {//没被访问过就是新环
				k++;
				for(int j=i;vis[j]==0;j=arr[j]) {//遍历整个环
					vis[j]=1;
				}
			}
		}
		//初始有k个环，最终是有n个环
		//每一次置换最多会多出1个环，那么最少要进行n-k次
		System.out.println(n-k);
		
	}
}
