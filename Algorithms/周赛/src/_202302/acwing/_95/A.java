package _202302.acwing._95;
import java.util.*;

public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static int[] arr = new int[N];
	static int x1,y1,x2,y2;
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		System.out.println(Math.max(Math.abs(x1-x2), Math.abs(y1-y2)));
	}
}
