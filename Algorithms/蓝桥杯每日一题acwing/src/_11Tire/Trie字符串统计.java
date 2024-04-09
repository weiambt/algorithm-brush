package _11Tire;
import java.util.*;
import java.math.*;
import java.io.*;

public class Trie×Ö·û´®Í³¼Æ {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int n,m;
		static int[][] son = new int[N][26];
		static int[] cnt = new int[N];
		static int idx = 0;
		
		static void insert(char[] str) {
			int p=0;
			for(int i=0;i<str.length;i++) {
				int u = str[i]-'a';
				if(son[p][u]==0) son[p][u]= ++idx;
				p = son[p][u];
			}
			cnt[p]++;
		}
		
		static int query(char[] str) {
			int p = 0;
			for(int i=0;i<str.length;i++) {
				int u = str[i]-'a';
				if(son[p][u]==0) return 0;
				p = son[p][u];
			}
			return cnt[p];
		}
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			while(n-->0) {
				String s = sc.next();
				String str = sc.next();
				if("I".equals(s)) {
					insert(str.toCharArray());
				}else {
					System.out.println(query(str.toCharArray()));
				}
			}
		}
}
