package _03二分;

import java.util.*;
import java.math.*;
import java.io.*;

public class 四平方和 {
	static int INF = 0x3f3f3f3f;
	static int N = 20090000 , M = 2*N;
	static int n,q;
	static int[] f = new int[N];
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Arrays.fill(f, -1);

		for(int i=0;i<3000;i++) {
			for(int j=i;j<3000;j++) {
				if(f[i*i+j*j]==-1)
					f[i*i+j*j] = i;
			}
		}
		for(int i=0;i<3000;i++) {
			for(int j=i;j<3000;j++) {
				int x = n - i*i - j*j;
				if(f[x]==-1) continue;
				int d = (int)Math.sqrt(x - f[x]*f[x]);
				System.out.println(i+" "+j+" "+f[x]+" "+d);
				return;
			}
		}
		
	}
}
