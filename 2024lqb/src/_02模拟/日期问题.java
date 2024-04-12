package _02模拟;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class 日期问题 {
	static int[] dd = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	static boolean isLuner(int y) {
		return y%4==0 && y%100!=0 || y%400==0;
	}
	static int solve(int y,int m,int d) {
		if(y<=59)
			y += 2000;
		else y += 1900;
		if (isLuner(y))
			dd[2] = 29;
		else dd[2] = 28;
		if (m>12 || d>dd[m] || m==0 || d==0) return 0;
		return y*10000 + m*100 +d;
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] date = s.split("/");
		int a = Integer.parseInt(date[0]);
		int b = Integer.parseInt(date[1]);
		int c = Integer.parseInt(date[2]);
		TreeSet<Integer> se = new TreeSet<>();
		
		se.add(solve(a,b,c));
		se.add(solve(c,b,a));
		se.add(solve(c,a,b));
		
		Integer[] ans = se.toArray(new Integer[1]);
		for(int i=0;i<ans.length;i++) {
			if (ans[i]!=0) {
				int y = ans[i]/10000,m = ans[i]%10000/100,d = ans[i]%100;
				System.out.printf("%d-%02d-%02d\n",y,m,d);
			}
			
		}
		
		
	}
}
