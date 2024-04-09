package _02差分;

import java.util.*;
import java.math.*;
import java.io.*;

public class 差分 {
	static int INF = 0x3f3f3f3f;
	static int N = 201000 , M = 2*N;
	static int[] chafen = new int[N];//差分数组
	static int[] arr = new int[N];
	static int n,m;
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i = 1;i<=n;i++) {
			arr[i] = sc.nextInt();
			chafen[i] = arr[i] - arr[i-1];
		}
		while(m-->0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			chafen[l]+=c;
			chafen[r+1]-=c;
		}
		
		for(int i=1;i<=n;i++) {
			arr[i] = arr[i-1] + chafen[i];
			System.out.print(arr[i]+" ");
		}
	}
}
