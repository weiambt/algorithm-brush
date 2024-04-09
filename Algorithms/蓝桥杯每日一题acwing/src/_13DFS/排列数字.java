package _13DFS;

import java.util.*;
import java.math.*;
import java.io.*;

public class ÅÅÁĞÊı×Ö {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int n;
	static int[] ans = new int[N],st = new int[N];

	static void dfs(int len) {
		if(len==n) {
			for(int i=0;i<n;i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		for(int i=1;i<=n;i++) {
			if(st[i]==0) {
				st[i]=1;
				ans[len] = i;
				dfs(len+1);
				st[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(0);
	}
	
}
