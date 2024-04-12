package _02模拟;

import java.util.Scanner;

public class 回文日期 {
	static int N = 1010;
	static long ans;
	static int[] dd = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	static boolean isLuner(int y) {
		return y%4==0 && y%100!=0 || y%400==0;
	}
	static int nextDay(int date) {
		int y = date/10000,m = date%10000/100,d = date%100;
		if(isLuner(y))
			dd[2] = 29;
		else
			dd[2] = 28;
		d ++;
		if(d>dd[m]) {
			m ++;
			d = 1;
		}
		if(m>12) {
			y ++;
			m = 1;
			d = 1;
		}
		return y*10000+m*100+d;
		
	}
	static boolean check(int date) {
		char[] s = Integer.toString(date).toCharArray();
		boolean flag = true;
		for(int i=0;i<=s.length/2;i++)
			if (s[i]!=s[7-i]) {
				flag = false;
				break;
			}
		return flag;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		a = sc.nextInt();
		b = sc.nextInt();
		for(int i=a;i<=b;i=nextDay(i))
			ans += check(i)==true?1:0;
		System.out.println(ans);
	}
}
