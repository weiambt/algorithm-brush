package _10kmp;

import java.util.*;
import java.math.*;
import java.io.*;

public class 周期 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010000 , M = 2*N;
	static char[] p = new char[N];
	static int[] ne = new int[N];
	static int n,m;
	static void getNext() {
		for(int i=2,j=0;i<=n;i++) {
			while(j>0 && p[i]!=p[j+1]) j = ne[j];
			if(p[i]==p[j+1])j++;
			ne[i]=j;
		}
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int cnt=1;
		while(true) {
			n = sc.nextInt();
			if(n==0) break ;
			p = (" "+sc.next()).toCharArray();
			getNext();
			out.println("Test case #"+cnt++);
			for(int i=2;i<=n;i++) {//枚举所有前缀
				int t = i-ne[i];
				if(i%t==0 && i/t>1) {
					out.println(i+" "+i/t);
				}
			}
			out.println();
		}
		out.flush();
	}
}
