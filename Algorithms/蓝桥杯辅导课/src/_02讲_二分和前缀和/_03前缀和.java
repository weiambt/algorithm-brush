package _02��_���ֺ�ǰ׺��;
import java.util.*;
import java.math.*;

public class _03ǰ׺�� {
		static int INF = 0x3f3f3f3f;
		static int N = 101000;
		static int[] s = new int[N];
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();
			for(int i=1;i<=n;i++) 
				s[i]=s[i-1]+sc.nextInt();
			
			while(m-->0) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				System.out.println(s[y]-s[x-1]);
			}
		}

}
