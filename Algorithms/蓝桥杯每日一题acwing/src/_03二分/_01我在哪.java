package _03����;

import java.util.*;
import java.math.*;
import java.io.*;

public class _01������ {
	static int INF = 0x3f3f3f3f;
	static int N = 201000 , M = 2*N;
	static int n,m;
	static String s;
	static Map<String, Integer> mp = new HashMap<String, Integer>();
	static int check(int len) {
		for(int i=0;i<=s.length()-len;i++) {
			String subString = s.substring(i,i+len);
			mp.put(subString,mp.getOrDefault(subString,0)+1);
			if(mp.get(subString)>1) 
				return 0;
		}
		return 1;
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.next();
		int l = 1,r = n;
		while(l<r) {
			int mid = l + r >>1;
			if(check(mid)==1) r=mid;
			else l = mid+1;
		}
		System.out.println(l);
	}
}
