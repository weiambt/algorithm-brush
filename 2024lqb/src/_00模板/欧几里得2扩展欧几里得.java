package _00模板;
import java.util.*;

public class 欧几里得2扩展欧几里得 {
	static int N = 3030;
	
	//最后x,y是 ax+by=gcd(a,b)的解
	static int x,y;
	static int exgcd(int a,int b) {
		if(b==0) {
			x=1;y=0;
			return a;
		}
		int gcd = exgcd(b,a%b);
		int t = x;
		x = y;
		y = t - a/b *y;
		return gcd;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//计算ax+by = c的解
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int gcd = exgcd(a,b);
		if(c%gcd==0) {
			System.out.println("有解");
			x *= (c/gcd);
			y *= (c/gcd);
			System.out.println("x="+x+",y="+y);
		}else {
			System.out.println("无解");
		}
	}
}
