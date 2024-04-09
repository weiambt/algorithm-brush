package _99备战国赛;

import java.util.*;
import java.math.*;
import java.io.*;

public class 取石子游戏 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 80100;
	static int[] sg = new int[N];
	static int n,m,k;public 取石子游戏() {
		// TODO Auto-generated constructor stub
	}
	static int calSg(int n) {
		if(sg[n]!=-1) return sg[n];
		HashSet<Integer> se = new HashSet<Integer>();
		if(n-1>=0)
			se.add(calSg(n-1));
		if(n-2>=0)
		se.add(calSg(n-2));
		if(n-k>=0)
			se.add(calSg(n-k));
		for(int i=0;;i++)
			if(!se.contains(i))
				return sg[n] = i;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		m = sc.nextInt();
//		while(m-->0) {
			Arrays.fill(sg,-1);
//			n = sc.nextInt();
//			k = sc.nextInt();
//			if(calSg(n)!=0)
//				System.out.println("Alice");
//			else {
//				System.out.println("Bob");
//			}
//		}
		for(int i=1;i<=10;i++)
			for(int j=1;j<=10;j++) {
				Arrays.fill(sg,-1);
				n = i;
				k = j;
				int res = calSg(n)==0?0:1;
				System.out.println(i+" "+j+" :"+res);
			}
		
		
	}
	
}

