package _13DFS;
import java.util.*;
import java.math.*;
import java.io.*;

public class ´ø·ÖÊı {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int n,ans;
	static int[] tmp = new int[10],vis = new int[10];
	static int get(int l,int r){
		int res = 0;
		for(int i=l;i<=r;i++)
			res =  res * 10 + tmp[i];
		return res;
	}
	static void dfs(int len) {
		if(len==9) {
			for(int i=0;i<=6;i++)
				for(int j=i+1;j<=7;j++) {
					int a = get(0, i);
					int b = get(i+1, j);
					int c = get(j+1, 8);
					if(a*c + b ==n*c) ans++;
				}
//			for (int i = 0; i < 9; i++) {
//				System.out.print(tmp[i]+" ");
//			}
//			System.out.println();

			return;		
		}
		for(int i=1;i<=9;i++) {
			if(vis[i]==0) {
				vis[i] = 1;
				tmp[len] = i;
				dfs(len+1);
				vis[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(0);
		System.out.println(ans);
	}
	
}
