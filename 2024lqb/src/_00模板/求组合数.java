package _00模板;
import java.util.*;

public class 求组合数 {
	static int N = 3030;
	static int[] st = new int[N];
	static long[][] comb = new long[N][N];
	static void initComb() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0)
					comb[i][j] = 1;
				else comb[i][j] = comb[i-1][j] + comb[i-1][j-1];
			}
		}
	}
	public static void main(String[] args) {
		initComb();
		System.out.println(comb[4][2]);
	}
}
