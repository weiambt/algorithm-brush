package ÀýÌâ;

import java.util.*;
import java.math.*;
import java.io.*;

public class dandiaoduilieyouhuadp {
		static int INF = 1000000007;
		static int N = 1010 , M = 2*N;
		static int[][] arr = new int[N][N],ma = new int[N][N],mi = new int[N][N];
		static int[] milie = new int[N],malie = new int[N];
		static int n,a,b,ans=Integer.MAX_VALUE;
		static int[] q = new int[N];
		static int hh=0,tt=-1;
		
		static void getMin(int[] w,int[] f,int len) {
			hh = 0;tt = -1;
			for(int i=1;i<=len;i++) {
				if(hh<=tt && i-n+1>q[hh])
					hh++;
				while(hh<=tt && w[q[tt]]>=w[i])
					tt--;
				q[++tt] = i;
				f[i] = w[q[hh]];
			}
		}
		
		static void getMax(int[] w,int[] f,int len) {
			hh = 0;tt = -1;
			for(int i=1;i<=len;i++) {
				if(hh<=tt && i-n+1>q[hh])
					hh++;
				while(hh<=tt && w[q[tt]]<=w[i])
					tt--;
				q[++tt] = i;
				f[i] = w[q[hh]];
			}
		}
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();
			b = sc.nextInt();
			n = sc.nextInt();
			for(int i=1;i<=a;i++) 
				for(int j=1;j<=b;j++) 
					arr[i][j] = sc.nextInt();
			
			for(int i=1;i<=a;i++) {
				getMin(arr[i], mi[i], b);
				getMax(arr[i], ma[i], b);
			}
			
			hh = 0;tt = -1;
			for(int j=n;j<=b;j++) {//ÁÐ
				int[] tmp = new int[a+1];
				int[] tmp2 = new int[a+1];
				for(int i=1;i<=a;i++) {//ÐÐ
					tmp[i] = mi[i][j];
					tmp2[i] = ma[i][j];
				}
				getMin(tmp, milie, a);
				getMax(tmp2, malie, a);
				for(int i=n;i<=a;i++)
					ans = Math.min(ans,malie[i]-milie[i]);
			}

			System.out.println(ans);	
		}
}

