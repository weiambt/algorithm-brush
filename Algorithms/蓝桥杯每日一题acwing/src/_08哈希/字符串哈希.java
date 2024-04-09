package _08哈希;

import java.util.*;
import java.math.*;
import java.io.*;

public class 字符串哈希 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static char[] str = new char[N];
	static int[] hash = new int[N],pow = new int[N];
	static int n,m;
	static int P = 131;
	//计算子串的哈希值
	static int query(int l,int r) {
		return hash[r] - hash[l-1]*pow[r-l+1];
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		String string = " "+sc.next();
		str = string.toCharArray();
		pow[0]=1;
		hash[0]=0;
		for(int i=1;i<=n;i++) {
			hash[i] = hash[i-1]*P + str[i];
			pow[i] = pow[i-1]*P;//预处理次方
		}

		while(m-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			if(query(a,b) == query(c,d)) System.out.println("Yes");
			else System.out.println("No");
		}
	}
}
