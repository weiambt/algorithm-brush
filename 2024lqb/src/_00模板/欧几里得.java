package _00ģ��;
import java.util.*;

public class ŷ����� {
	static int N = 3030;
	static int[] st = new int[N];
	static long[][] comb = new long[N][N];
	static int gcd(int a,int b) {
		return b==0?a:gcd(b,a%b);
	}
	public static void main(String[] args) {
		System.out.println(gcd(6,4));
	}
}
