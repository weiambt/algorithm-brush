package _01��_�ݹ������;
import java.util.*;
public class _03��쳲����� {
	static int INF = 0x3f3f3f3f;
	static int N = 50;
	static int n,m;
	static int[] fib = new int[N];
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		fib[1] = 0;
		fib[2] = 1;
		for(int i=3;i<=n;i++) {
			fib[i] = fib[i-1]+fib[i-2];
		}
		for(int i=1;i<=n;i++)
			System.out.print(fib[i]+" ");
	}
}
