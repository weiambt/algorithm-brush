package ецЬт;

import java.io.*;
import java.util.*;


public class C {
	static int INF = 0x3f3f3f3f;
	static int Mod = (int)1e9+7;
	static int N = 1010, M = 2*N;
	static int n,m,ans;

	static int[] day = {0,31,30,31,30,31,30,31,31,30,31,30,31};
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//		20000101
//		20000000101
		
		for(int y=2000;y<=2000000;y++) {
			if(y%4==0 && y%100!=0 || y%400==0)
				day[2] = 29;
			else day[2] = 28;
			for(int m=1;m<=12;m++) {
				for(int d=1;d<=day[m];d++) {
					if(y%m==0 && y%d==0) 
						ans++;
					if(y==2000000) {
						System.out.println(ans);
						return;
					}
				}
			}
		}
		System.out.println(ans);

		

	}
}