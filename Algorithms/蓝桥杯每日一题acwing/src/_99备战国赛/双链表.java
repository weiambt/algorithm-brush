package _99备战国赛;

import java.util.*;
import java.math.*;
import java.io.*;

public class 双链表 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 80100;
	static int[] l = new int[N],r = new int[N],e = new int[N];
	static int n,m,k,idx=1;
	static void addRight(int k,int val) {
		r[idx] = r[k];					
		l[idx] = k;
		l[r[k]] = idx;
		r[k] = idx;
		e[idx] = val;
		idx++;
	}
	static void remove(int k) {
		l[r[k]] = l[k];
		r[l[k]] = r[k];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		while(m-->0) {
			String op = sc.next();
			if(op.length()==1) {
				int x = sc.nextInt();
				if(op.equals("L")) {
					
				}else if(op.equals("R")) {
					
				}else {
					
				}
			}else {
				int k = sc.nextInt();
				int x = sc.nextInt();
				if(op.equals("IL")) {
					
				}else {
					
				}
			}
		}

		
		
	}
	
}

