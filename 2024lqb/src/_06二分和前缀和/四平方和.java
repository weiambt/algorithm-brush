package _06二分和前缀和;

import java.util.*;
import java.io.*;
import java.math.*;

public class 四平方和 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010,M = 2*N;
	static int n,k;
	static long ans;
	static int[] f = new int[3005000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		Arrays.fill(f,-1);
		for(int i=0;i<N;i++) {
			for(int j=i;j<N;j++) {
				if (f[i*i+j*j]==-1)
					f[i*i+j*j] = i;
			}
		}
		for(int i=0;i<N;i++) {
			for (int j=i;j<N;j++) {
				int s = n-i*i-j*j;
				int k = f[s];
				if(k==-1) continue;
				int z = (int)Math.sqrt(s-k*k);
				System.out.println(i+" "+j+" "+k+" "+z);
				return;
			}
		}
		
		
		
		
	}
	
	
}
