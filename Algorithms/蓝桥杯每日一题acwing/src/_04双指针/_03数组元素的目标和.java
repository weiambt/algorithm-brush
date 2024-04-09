package _04双指针;

import java.util.*;
import java.math.*;
import java.io.*;

public class _03数组元素的目标和 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] a = new int[N],b = new int[N];
	static int n,m,x;
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i=1;i<=m;i++) {
			b[i] = sc.nextInt();
		}
		
		int i=1,j=m;
		while(i<=n && j>0) {
			int t = a[i] + b[j];
			if(t==x) {
				i--;j--;
				System.out.println(i+" "+j);
				break;
			}
			if(t>x) j--;
			else i++;
		}
	}
}
