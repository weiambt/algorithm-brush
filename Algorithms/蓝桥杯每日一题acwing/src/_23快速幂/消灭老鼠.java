package _23快速幂;

import java.util.*;
import java.math.*;
import java.io.*;

public class 消灭老鼠 {
	static int INF = 0x3f3f3f3f;
	static int Mod = 233333;
	static int N = 1010 , M = 2*N;
	static int n,x;
	
	static int qpow(int a,int b) {
		int res = 1;
		while(b>0) {
			if((b&1)==1) res = res * a %Mod;
			b>>=1;
			a = a*a%Mod;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		n = sc.nextInt();
		System.out.println(qpow(x,n));
	}
	
}

