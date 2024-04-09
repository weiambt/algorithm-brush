package _10kmp;
import java.util.*;
import java.math.*;
import java.io.*;

public class _01KMP×Ö·û´® {
		static int INF = 0x3f3f3f3f;
		static int N = 1010000 , M = 2*N;
		static char[] p,s;
		static int[] ne = new int[N];
		static int n,m;
		static void getNext() {
			for(int i=2,j=0;i<=n;i++) {
				while(j>0 && p[i]!=p[j+1]) 
					j=ne[j];
				if(p[i]==p[j+1])
					j++;
				ne[i] = j;
			}
		}
		public static void main(String[] sss) {
			Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
			PrintWriter out = new PrintWriter(System.out);
			n = sc.nextInt();
			p = (" "+sc.next()).toCharArray();
			m = sc.nextInt();
			s = (" "+sc.next()).toCharArray();
			getNext();
			for(int i=1,j=0;i<=m;i++) {
				while(j>0 && s[i]!=p[j+1])
					j=ne[j];
				if(s[i]==p[j+1]) j++;
				if(j==n) {//Æ¥Åä³É¹¦
					out.print(i-n+" ");
					j = ne[j];
				}
			}
		}
}
