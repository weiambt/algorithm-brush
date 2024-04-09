package _08¹şÏ£;
import java.util.*;
import java.math.*;
import java.io.*;

public class ±¿×¾µÄÊÖÖ¸ {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int[] dx = {1,0,-1,0};
		static int[] dy = {0,1,0,-1};
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			char[] a = sc.next().toCharArray();
			char[] b = sc.next().toCharArray();
			int ans1=0,ans2=0;
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<b.length;j++) {
					int ni = (a[i]-'0')==1?0:1,nj;
					a[i] = (char) ('0'+ni);
					int sum1 = sum2(a),sum2;
					int oj = b[j]-'0';
					for(int k=0;k<=2 && k!=oj;k++) {
						nj = k;
						b[j] = (char) ('0'+nj);
						sum2 = sum3(b);
						if(sum1==sum2) {
							System.out.println(sum1);
							return;
						}
					}
					a[i] = ((a[i]-'0')==1?'0':'1');
					b[j] = (char) (oj+'0');
				}
			}
		}
		static int sum2(char[] s) {
			int res = 0;
			for(int i=0;i<s.length;i++) {
				res = res * 2 + s[i]-'0';
			}
			return res;
		}
		static int sum3(char[] s) {
			int res = 0;
			for(int i=0;i<s.length;i++) {
				res = res * 3 + s[i]-'0';
			}
			return res;
		}
}
