package _04Ë«Ö¸Õë;

import java.util.*;
import java.math.*;
import java.io.*;

public class _01×Ö·û´®É¾¼õ {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int n,m;
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String s = sc.next();
		s+=" ";
		int ans = 0;
		for(int i=0;i<s.length() ;i++) {
			if(s.charAt(i)!='x' || s.charAt(i) == s.charAt(i+1))
				continue;
			int j=i;
			while(j>=0 && s.charAt(j)==s.charAt(i)) 
				j--;
			if(i-j>=3) ans += i-j-2;
		}
		System.out.println(ans);
	}
}
