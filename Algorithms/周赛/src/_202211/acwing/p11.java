package _202211.acwing;
import java.util.*;
public class p11 {
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		char ans[] = new char[] {'a','b','c','d','e'};
		int n = sc.nextInt();
		int censhu=0,zhecen=0;
		for(int i=1;i<200;i++) {
			if( n>5*(Math.pow(2,i-1)-1) && n<=5*(Math.pow(2,i)-1)) {
				censhu = i;
				zhecen = (int) (n - 5*(Math.pow(2,i-1)-1));
				break;
			}
		}
		System.out.println(censhu);
		System.out.println(zhecen);
		int idx = (int) (zhecen/Math.pow(2, censhu-1));
		System.out.println(ans[idx]);
		
		
		
	}
}
