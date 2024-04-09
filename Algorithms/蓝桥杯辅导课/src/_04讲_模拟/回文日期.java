package _04讲_模拟;

import java.util.*;

public class 回文日期 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int n;
	static int[] d = {0,31,30,31,30,31,30,31,31,30,31,30,31};
	
	static int nextDay(int n) {
		int year = n/10000;
		int mon = n%10000/100;
		int day = n%100;
		
		//判断闰年，确定2月有多少天
		if(year%4==0 && year%100!=0 || year%400==0) 
			d[2] = 29;
		else d[2] = 28;
			
		//计算
		day++;
		if(day>d[mon]) {
			mon++;
			day = 1;
		}
		if(mon>12) {
			mon = 1;
			year++;
		}
		return year*10000+mon*100+day;
	}
	static boolean check(int n) {
		char[] d = String.valueOf(n).toCharArray();
		for(int i=0;i<4;i++) {
			if(d[i]!=d[7-i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int from = sc.nextInt();
		int to = sc.nextInt();
		int ans = 0;
		for(int i=from;i<=to;i=nextDay(i)) {
			if(check(i))
				ans++;
		}
		System.out.println(ans);
	}
}
