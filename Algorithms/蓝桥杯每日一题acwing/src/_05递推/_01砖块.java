package _05递推;
import java.util.*;
import java.math.*;
import java.io.*;

public class _01砖块 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			m = sc.nextInt();
			
			while(m-->0) {
				n = sc.nextInt();
				char[] s = sc.next().toCharArray();
				char[] s2 = s.clone();
				ArrayList<Integer> ans = new ArrayList<Integer>();
				int cnt = 0;
				//全部转换成B
				for(int i=0;i<s.length-1;i++) {
					if(s[i]=='B') continue;
					s[i+1] = s[i+1]=='B'?'W':'B';
					ans.add(i+1);
					cnt++;
				}
				if(s[s.length-1]=='B') {
					System.out.println(cnt);
					for(Integer i: ans)
						System.out.print(i+" ");
					if(cnt>0)
						System.out.println();
					continue;
				}
				//全部转换成W
				cnt = 0;
				ans.clear();
				for(int i=0;i<s2.length-1;i++) {
					if(s2[i]=='W') continue;
					s2[i+1] = s2[i+1]=='B'?'W':'B';
					ans.add(i+1);
					cnt++;
				}
				if(s2[s2.length-1]=='W') {
					System.out.println(cnt);
					for(Integer i: ans)
						System.out.print(i+" ");
					if(cnt>0)
						System.out.println();
					continue;
				}
				System.out.println(-1);
			}
		}
}
