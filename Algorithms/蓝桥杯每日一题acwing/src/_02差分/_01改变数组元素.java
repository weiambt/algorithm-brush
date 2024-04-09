package _02差分;

import java.util.*;
import java.math.*;
import java.io.*;

public class _01改变数组元素 {
	static int INF = 0x3f3f3f3f;
	static int N = 201000 , M = 2*N;
	static int[] chafen = new int[N];//差分数组
	static int[] a = new int[N];
	static int n,m;
	//对原数组[l,r]的值+v
	static void add(int l,int r,int v){
	    chafen[l]+=v;
	    chafen[r+1]-=v;
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		while(m-->0) {
			Arrays.fill(chafen, 0);
			n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				a[i] = sc.nextInt();
				if(a[i]==0) continue;
				if(a[i]>i) a[i]=i;
				int l = i-a[i]+1;//起始位置
				add(l,i,1);//+1
			}
			//对差分数组求前缀和，也就是最终答案
			for(int i=1;i<=n;i++) {
				chafen[i] += chafen[i-1];
				if(chafen[i]!=0) 
					System.out.print(1+" ");
				else
					System.out.print(0+" ");
			}
			System.out.println();
		}
	}
}
