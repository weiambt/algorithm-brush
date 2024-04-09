package _02讲_二分和前缀和;
import java.util.*;
import java.math.*;

public class _02数的三次方根 {
		static int INF = 0x3f3f3f3f;
		static int N = 10 , M = 2*N;
		static int[] dx = {1,0,-1,0};
		static int[] dy = {0,1,0,-1};
		static double n;
		
		static double find(double l,double r,double x) {
			while(r-l>1e-6) {
				double mid = (l+r)/2;
				if(mid*mid*mid >= x) r = mid;
				else l = mid;//不用+1
			}
			return l;
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextDouble();
			double l = find(-10000,10000,n);
			System.out.printf("%.6f",l);
		}

}
