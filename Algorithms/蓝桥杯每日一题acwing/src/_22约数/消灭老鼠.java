package _22约数;

import java.util.*;
import java.math.*;
import java.io.*;

public class 消灭老鼠 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int n,x0,y0;

	static PII[] arr = new PII[N];
	static int idx;
	static HashSet<String> se = new HashSet<String>();

	static int gcd(int a,int b) {
		return b==0?a:gcd(b, a%b);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x0 = sc.nextInt();
		y0 = sc.nextInt();
		for(int i=0;i<n;i++) {
			arr[idx++] = new PII(sc.nextInt(),sc.nextInt());
		}
		int ans = 0;
		for(int i=0;i<n;i++) {

			int x = arr[i].x - x0;
			int y = arr[i].y - y0;
			se.add(String.valueOf(x/gcd(x, y) + " "+ y/gcd(x, y)));
			
		}
		System.out.println(se.size());
			
	}
	
}
class PII {
	int x,y;
	public PII(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
}
