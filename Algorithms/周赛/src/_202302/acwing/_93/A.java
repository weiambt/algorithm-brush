package _202302.acwing._93;
import java.util.*;
import java.io.*;
import java.math.*;
public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static int[] arr = new int[N];
	static int n,m;
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		System.out.println(m*(n/m+1));

	}
}
