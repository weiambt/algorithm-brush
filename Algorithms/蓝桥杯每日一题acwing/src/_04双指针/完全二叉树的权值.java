package _04双指针;
import java.util.*;
import java.math.*;
import java.io.*;

public class 完全二叉树的权值 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static long[] a = new long[N];
	static int n,d,k;
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt() + a[i-1];
		}
		long ans = 0,sum=0;
		int i;
		for(i=1;Math.pow(2, i)-1<=n;i++) {
			int start = (int) Math.pow(2, i-1);
			if(a[(int)Math.pow(2, i)-1] - a[start-1] > sum) {
				sum = a[(int)Math.pow(2, i)-1] - a[start-1];
				ans = i;
			}
		}
		//最后一层
		if(Math.pow(2, i-1) > 0 && a[n] - a[(int)Math.pow(2, i-1)-1] > sum)
			ans = i;
		System.out.println(ans);
			
	}
}

