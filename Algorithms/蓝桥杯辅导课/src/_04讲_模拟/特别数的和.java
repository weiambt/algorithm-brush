package _04��_ģ��;

import java.util.*;

public class �ر����ĺ� {
	static int INF = 0x3f3f3f3f;
	static int N = 1001000,M = 2*N;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		long ans = 0;
		for(int i=1;i<=n;i++) {
			int j = i;
			while(j>0) {
				if(j%10==2 || j%10==0 ||j%10==1 ||j%10==9 ) {
					ans+=i;
					break;
				}
				j/=10;
			}
		}
		System.out.println(ans);
		
	}
}
