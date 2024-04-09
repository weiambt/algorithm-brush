package _08¹şÏ£;

import java.util.*;
import java.math.*;
import java.io.*;

public class Ä£ÄâÉ¢ÁĞ±í {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static HashSet<Integer> se = new HashSet<Integer>();
	static int n,m;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		while(n-->0) {
			String string = sc.next();
			int x = sc.nextInt();
			if(string.equals("I")) se.add(x);
			else System.out.println(se.contains(x)==true?"Yes":"No");
		}
	}
}
