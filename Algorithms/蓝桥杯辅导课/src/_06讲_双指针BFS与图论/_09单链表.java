package _06讲_双指针BFS与图论;

import java.util.*;
import java.math.*;
import java.io.*;

public class _09单链表 {
	static int INF = 0x3f3f3f3f;
	static int N = 1100 , M = 2*N;
	static int[][] vis = new int[N][N];
	static int[] e = new int[N],ne = new int[N];
	static int head = -1,idx = 1;
	static int m;
	static void addHead(int x) {
		e[idx] = x;
		ne[idx] = head;
		head = idx++;
	}
	static void insert(int k,int val) {
		ne[idx] = ne[k];
		e[idx] = val;
		ne[k] = idx++;
	}
	static void delete(int k) {
		ne[k] = ne[ne[k]];
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();

		while(m-->0) {
			String string = sc.next();
//			System.out.println(string);
			if(string.equals("I")) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				insert(a,b);
			}else {
				int a = sc.nextInt();
				if(string.equals("H")) 
					addHead(a);
				else {
					if(a==0) head = ne[head];
					else delete(a);
				}
			}
		}
		int t = head;
		while(t!=-1) {
			System.out.print(e[t]+" ");
			t=ne[t];
		}
	}
}
