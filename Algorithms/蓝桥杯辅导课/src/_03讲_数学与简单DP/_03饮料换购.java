package _03讲_数学与简单DP;
import java.util.*;
import java.math.*;
import java.text.DateFormatSymbols;
import java.awt.geom.AffineTransform;
import java.io.*;

public class _03饮料换购 {
		static int INF = 0x3f3f3f3f;
		static int N = 101 , M = 2*N;
		static int n,m;
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			int ans = n;
			int cnt = n;//瓶盖的个数
			while(cnt>=3) {
				ans += cnt/3;
				cnt = cnt%3 + cnt/3;
			}
			System.out.println(ans);
		}
}
