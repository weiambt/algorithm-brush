package ËÑË÷;

import java.util.*;
import java.math.*;
import java.io.*;

public class _22¼Ó³ÉÐòÁÐ {
	static int INF = 0x3f3f3f3f;
	static int N = 1090 , M = 2*N;
	static int n,m,ans=N;
	static int[] arr = new int[N];
	static boolean dfs(int len,int maxLen) {
		if(len>maxLen)
			return false;
		if(arr[len-1]>n) return false;
		if(arr[len-1]==n) return true;
		int[] vis = new int[N];
		Arrays.fill(vis,0);
		
		for(int i=len-1;i>=0;i--) {
			for(int j=len-1;j>=0;j--) {
				int x = arr[i]+arr[j];
				
				if(x>n || vis[x]==1) continue;
				arr[len] = x;
				vis[x] = 1;
				if(dfs(len+1,maxLen)) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			if(n==0) break;
			int len = 1;
			arr[0] = 1;
			while(dfs(1,len)==false) {
				len++;
			}
//			System.out.println(len);
			for(int i=0;i<len;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
		}

	}
}
