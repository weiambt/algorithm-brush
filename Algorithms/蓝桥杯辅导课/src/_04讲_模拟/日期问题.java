package _04讲_模拟;

import java.time.Year;
import java.util.*;

public class 日期问题 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] day = {0,31,29,31,30,31,30,31,31,30,31,30,31};
	static Set<String> ans = new TreeSet<String>();
	
	static void check(int y,int m,int d) {
		if(m>12 || m<1) return;
		if(d>31 || d<1) return;
		
		if(y<60) y = 2000 + y;
		else y = 1900 + y;
		if(y%4==0 && y%100!=0 || y%400==0)
			day[2] = 29;
		else day[2] = 28;
		
		if(d>day[m]) return;
		String s = String.valueOf(y)+"-";
		if(m<10) s+="0";
		s+=m+"-";
		if(d<10) s+="0";
		s+=d;
		ans.add(s);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] ss = s.split("/");
		int a = Integer.parseInt(ss[0]);
		int b = Integer.parseInt(ss[1]);
		int c = Integer.parseInt(ss[2]);
		
		check(a, b, c);
		check(c, a, b);
		check(c, b, a);
		
		for(String i:ans)
			System.out.println(i);
	}
}
