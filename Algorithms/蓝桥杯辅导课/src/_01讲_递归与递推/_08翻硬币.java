package _01Ω≤_µ›πÈ”Îµ›Õ∆;
import java.util.*;
import java.math.*;
public class _08∑≠”≤±“ {
	static int INF = 0x3f3f3f3f;
	static int N = 10 , M = 2*N;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int n,m;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		char[] s1 = sc.next().toCharArray();
		char[] tar = sc.next().toCharArray();

		n = s1.length;
		
		int cnt = 0;
		for(int i=0;i<n-1;i++) {
			if(s1[i]!=tar[i]) {
				s1[i+1] = s1[i+1]=='*'?'o':'*';
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
